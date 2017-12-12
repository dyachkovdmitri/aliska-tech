package com.neiron.neiron.service;

import com.neiron.neiron.entities.Item;
import com.neiron.neiron.entities.Price;
import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.repos.ItemRepo;
import com.neiron.neiron.repos.PriceRepo;
import com.neiron.neiron.utils.XlsParser;
import com.neiron.neiron.utils.aliska.AliskaParser;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class ItemService {
    @Autowired
    private XlsParser xlsParser;

    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private PriceRepo priceRepo;

    @Autowired
    private AliskaParser aliskaParser;
    @Autowired
    CustomerService customerService;

    public Long loadPrice(MultipartFile file, Long priceId, Long customerAliskaId) throws IOException, InvalidFormatException {
        Long time = System.currentTimeMillis();
        ArrayList<RequestLine> requestLines = xlsParser.getRequestLines(priceId, file);
        ArrayList<Item> items = aliskaParser.parsePrice(priceId, requestLines, customerAliskaId);
        fillAliskaMonolog(items, time, "",customerAliskaId);
        itemRepo.save(items);
        return priceId;
    }

    public ArrayList<Item> getPrice(Long customerAliskaId, Long priceId) {
        ArrayList<Price> prices = priceRepo.findByCustomerAliskaIdAndId(customerAliskaId, priceId);
        if (prices.size() > 0) {
            return itemRepo.findByPriceId(priceId);
        } else {return new ArrayList<Item>();}
    }

    private String fillAliskaMonolog(ArrayList<Item> items, Long time, String extra, Long customerAliskaMonolog) {
        String aliskaMonolog = "";
        if (items.size() == 1) {
            aliskaMonolog += "В прайсе найдена всего одна строкa!";
        } else {
            aliskaMonolog += "В прайсе найдено " + items.size() + " строк";
        }
        Long count = 0L;
        for (Item item : items) {
            count+=item.getAccuracy();
        }
        aliskaMonolog += "В этом прайсе " + items.size()+" строк";
        aliskaMonolog += extra;
        aliskaMonolog += " Я потратила " + (System.currentTimeMillis() - time) + " мс своего ценного времени на анализ прайса! ";
        aliskaMonolog += " Это " + ((Long) ((System.currentTimeMillis() - time) / items.size())) + " мс на одно наименование! ";
        aliskaMonolog += "Средняя точность: "+ count/items.size();
        customerService.addMonolog(aliskaMonolog,customerAliskaMonolog);
        return aliskaMonolog;
    }
}