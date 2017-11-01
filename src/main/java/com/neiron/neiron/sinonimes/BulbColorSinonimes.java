package com.neiron.neiron.sinonimes;

import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class BulbColorSinonimes {
    public final static HashMap<String, Integer> SINONIMES = new HashMap<>();

    static {
        SINONIMES.put("cl", 1);
        SINONIMES.put("прозр.", 1);
        SINONIMES.put("прозрачная", 1);
        SINONIMES.put("прозр", 1);
        SINONIMES.put("fr", 2);
        SINONIMES.put("матовая", 2);
        SINONIMES.put("дcмт", 2);
        SINONIMES.put("мат.", 2);
        SINONIMES.put("мат", 2);
    }

    public static Item addBulbColor(Item item) {
try{
        String[] words = item.getWords();
        for (int i = 0; i < words.length; i++) {
            if (SINONIMES.get(words[i].toLowerCase()) != null) {
                item.setBulbColor(SINONIMES.get(words[i].toLowerCase()));
                return item;
            }
        }}catch (Exception e){item.setBulbColor(-1);}
        return item;
    }
} 