package com.neiron.neiron.service;

import com.neiron.neiron.config.ParserConfigs;
import com.neiron.neiron.crud.BaseMsgResponce;
import com.neiron.neiron.crud.ListComment;
import com.neiron.neiron.entities.Customer;
import com.neiron.neiron.entities.CustomerRequest;
import com.neiron.neiron.entities.Item;
import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.repos.CustomerRepo;
import com.neiron.neiron.repos.CustomerRequestRepo;
import com.neiron.neiron.repos.RequestLineRepo;
import com.neiron.neiron.searchInPrice.SearchInPrice;
import com.neiron.neiron.utils.XlsParser;
import com.neiron.neiron.utils.aliska.AliskaParser;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@Service
public class LoadFileService {

    @Autowired
    CustomerRequestRepo customerRequestRepo;

    @Autowired
    AliskaParser aliskaParser;

    @Autowired
    RequestLineRepo requestLineRepo;

    @Autowired
    XlsParser xlsParser;

    @Autowired
    SearchInPrice searchInPrice;

    @Autowired
    CustomerRepo customerRepo;


    @Transactional(rollbackFor = Exception.class)
    public BaseMsgResponce loadOrder(MultipartFile file, Boolean brandImportant) throws Exception {
        long time = System.currentTimeMillis();
        String aliskaMonolog = "";
        BaseMsgResponce responce = new BaseMsgResponce();
        CustomerRequest customerRequest = new CustomerRequest();
        try {
            customerRequest.setStatus(1);
            customerRequest = customerRequestRepo.saveAndFlush(customerRequest);
            ArrayList<RequestLine> requestLines = xlsParser.getRequestLines(customerRequest.getId(), file);
            ListComment<RequestLine> lc = aliskaParser.parse(requestLines, brandImportant);
            requestLines = lc.getData();
            requestLineRepo.save(requestLines);
            customerRequest.setStatus(2);
            customerRequestRepo.saveAndFlush(customerRequest);
            responce.setAliskaMonolog(fillAliskaMonolog(requestLines, time, lc.getAliskaMonolog()));

        } catch (Exception e) {
            e.printStackTrace();
            responce.setAliskaMonolog(e.getMessage());
        }
        responce.setMsg(customerRequest.getId().toString());
        return responce;
    }

    public String checkWord(String word, Long customerAliskaId) {
        Customer customer = customerRepo.findById(customerAliskaId);
        String result = "";
        Item item = aliskaParser.parseLine(null, word);
        Integer accuracy = item.getAccuracy();
        if (accuracy > 0) {
            result += "Так-с...";
            result += "Это " + item.wordType() + " ";
            if (item.getWattage() != null) {
                result += item.getWattage() + "w ";
            }
            if (item.getVoltage() != null) {
                result += item.getVoltage() + "v ";
            }

            result += getClearParameters(item);
            ArrayList<Item> analogs = searchInPrice.getAllAnalogs(item);
            result += " В прайсе есть " + searchInPrice.getAllAnalogs(item).size() + " аналогов с такими параметрами.:\r\n";
            for(int i =0; i<analogs.size(); i++){
                result +=  analogs.get(i).getUnparsedLine()+" Сходство:"+compareItems(analogs.get(i),item)+"\r\n";
                if(i>6){result+="...";break;}
            }
            customer.addAliskaMonolog("<div> <br/> Я:"+ word+"</div>");
            customer.addAliskaMonolog("<div><br/> <b>Алиска:"+ result+"</b></div>");
            customerRepo.saveAndFlush(customer);
            return result;

        } else {
            customer.addAliskaMonolog("<div> Я: "+ word+"</div>");
            customer.addAliskaMonolog("<div><b>Алиска: Я ничо не понимаю(((</b></div>");
            customerRepo.saveAndFlush(customer);
            return "Я ничо не понимаю";}
    }

    private String getClearParameters(Item item) {
        String result="Мне понятен его ";
        if (item.getBrand() != null) {
            result += "брэнд, ";
        }
        if (item.getConnectorType() != null) {
            result += "цоколь, ";
        }
        if (item.getBulbColor() != null) {
            result += "покрытие колбы, ";
        }
        if (item.getBulbType() != null) {
            result += "тип колбы, ";
        }
        if (item.getKelvin() != null) {
            result += "цветовая температура";
        }
        return result+"... ";
    }

    private String fillAliskaMonolog(ArrayList<RequestLine> requestLines, Long time, String extra) {
        String aliskaMonolog = "";
        if (requestLines.size() == 1) {
            aliskaMonolog += "Фуух! Готово! В заявке найдена всего одна строкa!";
        } else {
            aliskaMonolog += "Фуух! Готово! В заявке найдено " + requestLines.size() + " строк";
        }
        Double count = 0D;
        for (RequestLine requestLine : requestLines) {
            if (requestLine.getAssortmentId() != null) {
                count++;
            }
        }
        aliskaMonolog += " Я смогла найти аналоги " + count.toString().substring(0, count.toString().length() - 2) + " строкам ";
        aliskaMonolog += " Это " + ((Double) (count * 100 / requestLines.size())).toString().substring(0, 3) + "%!";
        aliskaMonolog += extra;
        aliskaMonolog += " Я потратила " + (System.currentTimeMillis() - time) + " мс своего ценного времени на обсчет! ";
        aliskaMonolog += " Это " + ((Long) ((System.currentTimeMillis() - time) / requestLines.size())) + " мс на одно наименование! ";
        return aliskaMonolog;
    }

    private String compareItems(Item priceItem, Item requestItem) {
        Integer wordsIndex = compareWords(priceItem, requestItem.getWords());
        return ((Integer)(priceItem.compareWith(requestItem)*ParserConfigs.simpleWordImportant)).toString() +"+"+ wordsIndex.toString();
    }

    private Integer compareWords(Item priceItem, String[] requestWords) { //todo начать сравнивалка работает из рук вон плохо
        String[] priceWords = (priceItem.getUnparsedLine().replace("-", " ").replace("/", " ").replace("(", " ").replace(")", " ").split(" "));
        Integer resultIndex = 0;
        for (String priceWord : priceWords) {
            for (String requestWord : requestWords) {
                if (priceWord.equals(requestWord)&&!priceWord.equals("")&&!requestWord.equals("")) {
                    resultIndex++;
                }
            }
        }
        return resultIndex;
    }

} 