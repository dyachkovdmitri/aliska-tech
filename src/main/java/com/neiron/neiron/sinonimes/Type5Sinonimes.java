package com.neiron.neiron.sinonimes;

import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class Type5Sinonimes {
    public final static HashMap<String, Integer> SINONIMES = new HashMap<>();

      public static Item addType5(Item item) {

        String[] words = item.getUnparsedLine().split(" ");
        for (int i = 0; i < words.length; i++) {
            if (SINONIMES.get(words[i].toLowerCase()) != null) {
                item.setConnectorType(SINONIMES.get(words[i].toLowerCase()));
                return item;
            }
        }
        return item;
    }
} 