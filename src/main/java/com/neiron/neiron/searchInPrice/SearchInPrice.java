package com.neiron.neiron.searchInPrice;

import com.neiron.neiron.config.ParserConfigs;
import com.neiron.neiron.entities.Item;
import com.neiron.neiron.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SearchInPrice {
    @Autowired
    ItemRepo itemRepo;

    public Item getSimilarItemInPrice(Item item) {
        if (item.getAccuracy() < ParserConfigs.minAccuracy) {
            return null;
        }
        ArrayList<Item> items = getAllAnalogs(item);
        Item resultItem = null;
        Integer maxIndex = 0;
        for (Item item1 : items) {
            Integer index = compareItems(item1, item);
            if (index > maxIndex) {
                maxIndex = index;
                resultItem = item1;
            }
        }
        //System.out.println(item + ",  INDEX = " + maxIndex + ", Количество найденных слов : " + items.size());
        return resultItem;

    }

    public ArrayList<Item> getAllAnalogs(Item item) {
        return itemRepo.getItemByAttributes(
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
                item.getBrand(),
                item.getKelvin());
    }

    public Integer compareItems(Item priceItem, Item requestItem) {
        Integer wordsIndex = compareWords(priceItem, requestItem.getWords());
        return priceItem.compareWith(requestItem) + wordsIndex;
    }

    private Integer compareWords(Item priceItem, String[] requestWords) {
        String[] priceWords = (priceItem.getUnparsedLine().replace("-", " ").replace("/", " ").replace("(", " ").replace(")", " ").split(" "));
        Integer resultIndex = 0;
        for (String priceWord : priceWords) {
            for (String requestWord : requestWords) {
                if (priceWord.equals(requestWord)) {
                    resultIndex++;
                }
            }
        }
        return resultIndex / ParserConfigs.simpleWordImportant;
    }
}