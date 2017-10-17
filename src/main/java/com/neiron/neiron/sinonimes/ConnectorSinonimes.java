package com.neiron.neiron.sinonimes;

import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class ConnectorSinonimes {
    public final static  HashMap<String, Integer> SINONIMES = new HashMap<>();

    static {
        SINONIMES.put("е27", 1);
        SINONIMES.put("e27", 1);
        SINONIMES.put("e14", 2);
        SINONIMES.put("е14", 2);
        SINONIMES.put("e40", 3);
        SINONIMES.put("е40", 3);
        SINONIMES.put("g13", 4);
        SINONIMES.put("г13", 4);
        SINONIMES.put("b15d", 5);
    }

    public static Item addConnector(Item item) {

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


