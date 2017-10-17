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

    }

    public static Item addBrand(Item item) {

        String[] words = item.getUnparsedLine().split(" ");
        for (int i = 0; i < words.length; i++) {
            if (SINONIMES.get(words[i].toLowerCase()) != null) {
                item.setBrand(SINONIMES.get(words[i].toLowerCase()));
                return item;
            }
        }
        return item;
    }
} 