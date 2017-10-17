package com.neiron.neiron.sinonimes;

import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class BulbTypeSinonimes {
    public final static HashMap<String, Integer> SINONIMES = new HashMap<>();

    static {
        SINONIMES.put("a55", 1);
        SINONIMES.put("груша", 1);
        SINONIMES.put("грушевидная", 1);
        SINONIMES.put("a55", 1);
        SINONIMES.put("b35", 2);
        SINONIMES.put("б35", 2);
        SINONIMES.put("свеча", 2);
        SINONIMES.put("свечка", 2);
        SINONIMES.put("свечевидная", 2);
        SINONIMES.put("p45", 3);
        SINONIMES.put("п45", 3);
        SINONIMES.put("шарик", 3);
        SINONIMES.put("par38", 4);
        SINONIMES.put("пар38", 4);
        SINONIMES.put("par56", 5);
        SINONIMES.put("пар56", 5);
        SINONIMES.put("e50", 6);
        SINONIMES.put("е50", 6);
        SINONIMES.put("гриб", 6);
        SINONIMES.put("r50", 7);
        SINONIMES.put("р50", 7);
        SINONIMES.put("r63", 8);
        SINONIMES.put("р63", 8);
        SINONIMES.put("r80", 9);
        SINONIMES.put("р80", 9);
    }

    public static Item addBulbType(Item item) {

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