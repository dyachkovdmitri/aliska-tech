package com.neiron.neiron.sinonimes;

import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class ConnectorSinonimes {
    public final static HashMap<String, Integer> SINONIMES = new HashMap<>();

    static {
        SINONIMES.put("е27", 1);
        SINONIMES.put("e27", 1);
        SINONIMES.put("e14", 2);
        SINONIMES.put("е14", 2);
        SINONIMES.put("e40", 3);
        SINONIMES.put("е40", 3);
        SINONIMES.put("g13", 4);
        SINONIMES.put("tl-d", 4);
        SINONIMES.put("lfl", 4);
        SINONIMES.put("г13", 4);
        SINONIMES.put("b15d", 5);
        SINONIMES.put("в15d", 5);

        SINONIMES.put("g4", 9);
        SINONIMES.put("g12", 10);
        SINONIMES.put("rx7s", 11);

        SINONIMES.put("r7s", 12);
        SINONIMES.put("g6.35", 13);


        SINONIMES.put("gu4", 14);
        SINONIMES.put("gy6.35", 15);
        SINONIMES.put("g23", 16);
        SINONIMES.put("g24d-3", 17);
        SINONIMES.put("g5", 18);
        SINONIMES.put("tl5", 18);
        SINONIMES.put("fh", 18);
        SINONIMES.put("fq", 18);
        SINONIMES.put("g9", 19);
        SINONIMES.put("gu5.3", 20);
        SINONIMES.put("gu10", 21);
        SINONIMES.put("g24d", 22);
        SINONIMES.put("g53", 23);
        SINONIMES.put("2g7", 23);
        SINONIMES.put("2g11", 25);
        SINONIMES.put("g24q-3", 26);
        SINONIMES.put("gx24q-4", 27);
        SINONIMES.put("g24d-2", 28);
        SINONIMES.put("g24d-1", 29);
        SINONIMES.put("gy6.35", 30);
        SINONIMES.put("g10q", 31);
        SINONIMES.put("tl-e", 31);
        SINONIMES.put("gx53", 32);
        SINONIMES.put("k12S", 33);
        SINONIMES.put("g8.5", 34);
        SINONIMES.put("gx8.5", 35);
        SINONIMES.put("g24q-1", 36);
        SINONIMES.put("g24q-2", 37);
        SINONIMES.put("g24q-3", 38);
        SINONIMES.put("gx24q", 39);

        SINONIMES.put("baz15d", 101);
        SINONIMES.put("sv8.5", 102);
        SINONIMES.put("p14.5s", 103);
        SINONIMES.put("bau15s", 104);
        SINONIMES.put("w2.1x9.5d", 105);
        SINONIMES.put("bx8.4d", 106);
        SINONIMES.put("p43t", 107);
        SINONIMES.put("w3x16q", 108);
        SINONIMES.put("p20d", 109);
        SINONIMES.put("px26d", 110);
        SINONIMES.put("pk22s", 111);
        SINONIMES.put("b8.5d", 112);
        SINONIMES.put("px26d", 113);
        SINONIMES.put("ba9s", 114);
        SINONIMES.put("ва9s", 114);
        SINONIMES.put("ва15s", 115);
        SINONIMES.put("ba15s", 115);
        SINONIMES.put("p45t", 116);
        SINONIMES.put("p45t", 117);
        SINONIMES.put("b22d", 118);
        SINONIMES.put("в22d", 118);
        SINONIMES.put("bay15d",119);


    }

    public static Item addConnector(Item item) {
        try {
            String[] words = item.getWords();
            for (int i = 0; i < words.length; i++) {
                if (SINONIMES.get(words[i].toLowerCase()) != null) {
                    item.setConnectorType(SINONIMES.get(words[i].toLowerCase()));
                    return item;
                }
            }
        } catch (Exception e) {
            item.setConnectorType(-1);
        }
        return item;
    }
}


