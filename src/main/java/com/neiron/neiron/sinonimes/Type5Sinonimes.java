package com.neiron.neiron.sinonimes;

import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class Type5Sinonimes {
    public final static HashMap<String, Integer> SINONIMES = new HashMap<>();

    static {
        SINONIMES.put("клл", 1);
        SINONIMES.put("tl-d", 2);
        SINONIMES.put("dulucx", 1);
        SINONIMES.put("компакт.", 1);
        SINONIMES.put("компакт", 1);
        SINONIMES.put("компактная", 1);

    }

    public static Item addType5(Item item) {
        try {
            String[] words = item.getWords();
            for (int i = 0; i < words.length; i++) {
                if (SINONIMES.get(words[i].toLowerCase()) != null) {
                    item.setType5(SINONIMES.get(words[i].toLowerCase()));
                    return item;
                }
            }
        } catch (Exception e) {
            item.setType5(-1);
        }
        return item;
    }
} 