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

    public Long loadPrice(MultipartFile file, Long priceId) throws IOException, InvalidFormatException {
        ArrayList<RequestLine> requestLines = xlsParser.getRequestLines(priceId, file);
        ArrayList<Item> items = aliskaParser.parsePrice(priceId, requestLines);
        itemRepo.save(items);
        return priceId;
    }

    public ArrayList<Item> getPrice(Long customerAliskaId, Long priceId) {
        ArrayList<Price> prices = priceRepo.findByCustomerAliskaIdAndId(customerAliskaId, priceId);
        if (prices.size() > 0) {
            return itemRepo.findByPriceId(priceId);
        } else {return new ArrayList<Item>();}
    }
}