package com.neiron.neiron.utils;

import com.neiron.neiron.crud.BaseMsgResponce;
import com.neiron.neiron.crud.ListComment;
import com.neiron.neiron.entities.Company;
import com.neiron.neiron.entities.CustomerRequest;
import com.neiron.neiron.entities.Item;
import com.neiron.neiron.entities.RequestLine;

import com.neiron.neiron.repos.CustomerRequestRepo;
import com.neiron.neiron.repos.ItemRepo;
import com.neiron.neiron.repos.RequestLineRepo;
import com.neiron.neiron.utils.aliska.AliskaParser;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class XlsParser {
//    public BaseMsgResponce parseXls(MultipartFile file, Boolean brandImportant) {
//        long time = System.currentTimeMillis();
//        BaseMsgResponce responce = new BaseMsgResponce();
//        String aliskaMonolog = "";
//        CustomerRequest customerRequest = new CustomerRequest();
//        customerRequest.setStatus(1);
//        customerRequest = customerRequestRepo.saveAndFlush(customerRequest);
//        ArrayList<RequestLine> requestLines;
//        try {
//            requestLines = getRequestLines(customerRequest.getId(), file);
//
//            if (requestLines.size() == 1) {
//                aliskaMonolog += "Фуух! Готово! В заявке найдена одна строкa";
//            } else {
//                aliskaMonolog += "Фуух! Готово! В заявке найдено " + requestLines.size() + " строк";
//            }
//            //requestLineRepo.save(requestLines);
//            customerRequest.setStatus(2);
//            customerRequestRepo.saveAndFlush(customerRequest);
//            //ListComment<RequestLine> lc = parse(requestLines, brandImportant);
//            requestLines = lc.getData();
//            Double count = 0D;
//            for (RequestLine requestLine : requestLines) {
//                if (requestLine.getAssortmentId() != null) {
//                    count++;
//                }
//            }
//            aliskaMonolog+= " Я смогла найти аналоги " + count.toString().substring(0,count.toString().length()-2) + " строкам ";
//            aliskaMonolog+= " Это " + ((Double)(count*100/requestLines.size())).toString().substring(0,3) + "%!";
//            aliskaMonolog+= lc.getAliskaMonolog();
//            aliskaMonolog+= " Я потратила " + (System.currentTimeMillis()-time) + " мс своего ценного времени на обсчет!";
//            aliskaMonolog+= " Это " + ((Long)((System.currentTimeMillis()-time)/requestLines.size())) + " мс на одно наименование! ";
//
//            requestLineRepo.save(requestLines);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        responce.setMsg(customerRequest.getId().toString());
//        responce.setAliskaMonolog(aliskaMonolog);
//        return responce;
//    }


//    public ArrayList<Item> parsePrice(Long companyId, ArrayList<RequestLine> lines) {
//        return aliskaParser.parsePrice(companyId, lines);
//    }
//
//    private ListComment<RequestLine> parse(ArrayList<RequestLine> lines, Boolean brandImportant) {
//
//        return aliskaParser.parse(lines, brandImportant);
//    }

    public ArrayList<RequestLine> getRequestLines(Long customerRequestId, MultipartFile file) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        XLSStructure structure = new XLSStructure(sheet);
        ArrayList<RequestLine> lines = new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            Row row = sheet.getRow(structure.getBeginString() + i);
            if (row != null) {
                String unparsedLine = "Строка не понята";
                try {
                    unparsedLine = row.getCell(structure.getItemName()).toString();

                    //System.out.println(unparsedLine);
                    String amountString;
                    String priceString;
                    int ammount;
                    long price;
                    try {
                        amountString = row.getCell(structure.getAmount()).toString();
                        priceString = row.getCell(structure.getPrice()).toString();
                        ammount = (int)row.getCell(structure.getAmount()).getNumericCellValue(); //Integer.parseInt(amountString.substring(0, amountString.indexOf(".")));
                        price = (long)row.getCell(structure.getPrice()).getNumericCellValue(); //todo 111
                    } catch (Exception e) {
                        ammount = 0;
                        price = 0l;
                    }
                    RequestLine requestLine = new RequestLine();
                    requestLine.setUnparsedLine(unparsedLine);
                    requestLine.setPrice(price);
                    requestLine.setAmmount(ammount);
                    requestLine.setRequestId(customerRequestId);
                    if (unparsedLine.length() > 3) {
                        lines.add(requestLine);
                    }
                } catch (Exception ignored) {
                }
            } else {
                return lines;
            }
        }
        return lines;
    }
}