package com.neiron.neiron.sinonimes;

import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class Type2Sinonimes {
    public final static HashMap<String, Integer> SINONIMES = new HashMap<>();

    static {
        SINONIMES.put("led", 3);
        SINONIMES.put("pled", 3);
        SINONIMES.put("автомобильная", 5);
//        SINONIMES.put("tl-d", 3);
//        SINONIMES.put("cdm-t", 3);
//        SINONIMES.put("hqi-t", 3);
//        SINONIMES.put("nav-t", 3);
//        SINONIMES.put("автомобильная", 4);
//        SINONIMES.put("специальная", 5);


    }

    public static Item addType2(Item item) {
        try{

        String[] words = item.getWords();
        for (int i = 0; i < words.length; i++) {
            if (SINONIMES.get(words[i].toLowerCase()) != null) {
                item.setType2(SINONIMES.get(words[i].toLowerCase()));
                return item;
            }
        }}catch (Exception e){item.setType2(-1);}
        return item;
    }
} 