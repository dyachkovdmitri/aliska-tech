package com.neiron.neiron.service;

import com.neiron.neiron.entities.Customer;
import com.neiron.neiron.entities.Price;
import com.neiron.neiron.repos.PriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
@Service
public class PriceService {

@Autowired
PriceRepo priceRepo;

    public Price createNewPrice(String priceName, Boolean allVisible, Long customerAliskaId) {
        Price price= new Price();

        if (priceName == null) {
            priceName = "Лампа-" + new Date(System.currentTimeMillis()).toString().substring(4,10);
        }
        if(allVisible==null) {allVisible=false;}

        price.setAllVisible(allVisible);
        price.setCustomerAliskaId(customerAliskaId);
        price.setPriceName(priceName);
        price = priceRepo.saveAndFlush(price);
        return price;
    }

    public ArrayList<Price> getAvailablePrices(Long customerAliskaId) {
        return priceRepo.getByCustomerAliskaId(customerAliskaId);
    }
}