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
        return resultItem;

    }

    private ArrayList<Item> getAllAnalogs(Item item) {
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
                item.getBrand());

    }

    private Integer compareItems(Item priceItem, Item requestItem) {
        Integer index = 0;
        if (priceItem.getType1() != null) {
            index++;
        }
        if (priceItem.getType2() != null) {
            index++;
        }
        if (priceItem.getType3() != null) {
            index++;
        }
        if (priceItem.getType4() != null) {
            index++;
        }
        if (priceItem.getType5() != null) {
            index++;
        }
        if (priceItem.getWattage() != null) {
            index++;
        }
        if (priceItem.getVoltage() != null) {
            index++;
        }
        if (priceItem.getConnectorType() != null) {
            index++;
        }
        if (priceItem.getBulbColor() != null) {
            index++;
        }
        if (priceItem.getBulbType() != null) {
            index++;
        }
        if (priceItem.getBrand() != null) {
            index++;
        }
        if (priceItem.getLumen() != null) {
            index++;
        }
        if (priceItem.getKelvin() != null) {
            index++;
        }
        Integer wordsIndex = compareWords(priceItem, requestItem.getWords());

        return index + wordsIndex;
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