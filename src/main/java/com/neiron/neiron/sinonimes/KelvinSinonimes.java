package com.neiron.neiron.sinonimes;

import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class KelvinSinonimes {
        public final static HashMap<String, Integer> SINONIMES = new HashMap<>();

        static {
            SINONIMES.put("827", 1);
            SINONIMES.put("2700", 1);
            SINONIMES.put("2700k", 1);
            SINONIMES.put("830", 2);
            SINONIMES.put("833", 2);
            SINONIMES.put("3000", 2);
            SINONIMES.put("wdl", 2);
            SINONIMES.put("3000k", 2);
            SINONIMES.put("лб", 2);
            SINONIMES.put("33", 2);
            SINONIMES.put("ярко-бел.", 2);
            SINONIMES.put("840", 3);
            SINONIMES.put("842", 3);
            SINONIMES.put("640", 3);
            SINONIMES.put("4000", 3);
            SINONIMES.put("4000k", 3);
            SINONIMES.put("ndl", 3);

            SINONIMES.put("4200k", 3);
            SINONIMES.put("4k", 3);
            SINONIMES.put("845", 3);
            SINONIMES.put("4500", 3);
            SINONIMES.put("4500k", 3);
            SINONIMES.put("865", 4);
            SINONIMES.put("лд", 4);
            SINONIMES.put("965", 4);
            SINONIMES.put("864", 4);
            SINONIMES.put("765", 4);
            SINONIMES.put("дневн", 4);
            SINONIMES.put("дневн.", 4);
            SINONIMES.put("6500", 4);
            SINONIMES.put("cdl", 4);
            SINONIMES.put("6500k", 4);
            SINONIMES.put("fluora", 5);
            SINONIMES.put("36w/77", 5);
            SINONIMES.put("18w/77", 5);
            SINONIMES.put("natura", 6);
            SINONIMES.put("36w/76", 6);
            SINONIMES.put("18w/76", 6);
            SINONIMES.put("tuv", 7);
        }

        public static Item addKelvin(Item item) {
            try{
                String[] words = item.getWords();
                for (int i = 0; i < words.length; i++) {
                    if (SINONIMES.get(words[i].toLowerCase()) != null) {
                        item.setKelvin(SINONIMES.get(words[i].toLowerCase()));
                        return item;
                    }
                }}catch (Exception e){item.setBulbType(-1);}
            return item;
        }
    }