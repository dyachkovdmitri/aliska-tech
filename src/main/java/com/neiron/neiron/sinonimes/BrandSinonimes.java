package com.neiron.neiron.sinonimes;

import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class BrandSinonimes {
    public final static HashMap<String, Integer> SINONIMES = new HashMap<>();

    static {
        SINONIMES.put("philips", 1);
        SINONIMES.put("филипс", 1);
        SINONIMES.put("osram", 2);
        SINONIMES.put("осрам", 2);
        SINONIMES.put("silvania", 3);
        SINONIMES.put("sylvaniya", 3);
        SINONIMES.put("silvaniya", 3);
        SINONIMES.put("сильвания", 3);
        SINONIMES.put("сильваниа", 3);
        SINONIMES.put("сильванья", 3);
        SINONIMES.put("galad", 4);
        SINONIMES.put("navigator", 5);
        SINONIMES.put("иэк", 6);
        SINONIMES.put("iek", 6);
        SINONIMES.put("favor", 7);
        SINONIMES.put("фавор", 7);
        SINONIMES.put("космос", 8);
        SINONIMES.put("camelion", 9);
        SINONIMES.put("экономка", 10);
        SINONIMES.put("gauss", 11);
        SINONIMES.put("jazzway", 12);
        SINONIMES.put("новыйсвет", 13);//новый свет
        SINONIMES.put("брестский", 14);
        SINONIMES.put("майлуу-сууйский",15);
        SINONIMES.put("лисма", 16);
        SINONIMES.put("рефлакс", 17);
        SINONIMES.put("старт", 18);
        SINONIMES.put("кэлз", 19);
        SINONIMES.put("томский", 20);
        SINONIMES.put("онлайт", 21);
        SINONIMES.put("neon-night", 22);
        SINONIMES.put("импульс", 23);
        SINONIMES.put("спец-свет", 24);
    }

    public static Item addBrand(Item item) {
        try{
        String[] words = item.getWords();
        for (int i = 0; i < words.length; i++) {
            if (SINONIMES.get(words[i].toLowerCase()) != null) {
                item.setBrand(SINONIMES.get(words[i].toLowerCase()));
                return item;
            }
        }}catch (Exception e){item.setBrand(-1);}
        return item;
    }
} 