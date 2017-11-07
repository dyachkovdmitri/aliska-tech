package com.neiron.neiron.sinonimes;

import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class Type5Sinonimes {
    public final static HashMap<String, Integer> SINONIMES = new HashMap<>();

    static {
        SINONIMES.put("клл", 2);
        SINONIMES.put("tl-d", 1);

        SINONIMES.put("dulux", 2);
        SINONIMES.put("компакт.", 2);
        SINONIMES.put("компакт", 2);
        SINONIMES.put("efs", 2);
        SINONIMES.put("efh", 2);
        SINONIMES.put("4u", 2);
        SINONIMES.put("3u", 2);
        SINONIMES.put("1u", 2);
        SINONIMES.put("2u", 2);
        SINONIMES.put("spc", 2);
        SINONIMES.put("кэл-s", 2);

        SINONIMES.put("компактная", 2);

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