package com.neiron.neiron.sinonimes;


import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class Type4Sinonimes {
    public final static HashMap<String, Integer> SINONIMES = new HashMap<>();

    static {
//        SINONIMES.put("лон", 1);
//        SINONIMES.put("накал.", 1);
//        SINONIMES.put("галоген.", 2);
//        SINONIMES.put("галоген", 2);
//        SINONIMES.put("клл", 3);
//        SINONIMES.put("tl-d", 4);
        SINONIMES.put("дрл", 2);
//        SINONIMES.put("cdm-t", 5);
//        SINONIMES.put("hqi-t", 6);
//        SINONIMES.put("nav-t", 7);
//        SINONIMES.put("натриевая лампа низкого давления", 8);
    }

    public static Item addType4(Item item) {
        try {
            String[] words = item.getWords();
            for (int i = 0; i < words.length; i++) {
                if (SINONIMES.get(words[i].toLowerCase()) != null) {
                    item.setType4(SINONIMES.get(words[i].toLowerCase()));
                    return item;
                }
            }
        } catch (Exception e) {
            item.setType4(-1);
        }
        return item;
    }
}