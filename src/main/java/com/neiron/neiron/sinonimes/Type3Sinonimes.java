package com.neiron.neiron.sinonimes;

import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class Type3Sinonimes {
    public final static HashMap<String, Integer> SINONIMES = new HashMap<>();

    static {
        SINONIMES.put("лон", 1);
        SINONIMES.put("накал.", 1);
        SINONIMES.put("галоген.", 2);
        SINONIMES.put("галоген", 2);
        SINONIMES.put("клл", 3);
        SINONIMES.put("tl-d", 2);
        SINONIMES.put("cdm-t", 3);
        SINONIMES.put("hqi-t", 3);
        SINONIMES.put("nav-t", 3);
    }

    public static Item addType3(Item item) {

        String[] words = item.getUnparsedLine().split(" ");
        for (int i = 0; i < words.length; i++) {
            if (SINONIMES.get(words[i].toLowerCase()) != null) {
                item.setType3(SINONIMES.get(words[i].toLowerCase()));
                return item;
            }
        }
        return item;
    }
} 