package com.neiron.neiron.searchInPrice;

import com.neiron.neiron.entities.Item;
import com.neiron.neiron.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SearchInPrice {
    @Autowired
    ItemRepo itemRepo;

    public Long getSimilarItemInPrice(Item item) {

       ArrayList<Item> items = itemRepo.getItemByAttributes(
               item.getType1(),
               item.getType2(),
               item.getType3(),
               item.getType4(),
               item.getType5(),
               item.getWattage(),
               item.getVoltage(),
               item.getConnectorType(),
               item.getBulbColor(),
               item.getBulbType(),
               item.getBrand());
       if(items.size()>0){return items.get(0).getId();} else return null;

    }
} 