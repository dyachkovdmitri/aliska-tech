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
        SINONIMES.put("дс", 2);
        SINONIMES.put("дcмт", 2);
        SINONIMES.put("свечка", 2);
        SINONIMES.put("свечевидная", 2);
        SINONIMES.put("p45", 3);
        SINONIMES.put("п45", 3);
        SINONIMES.put("шарик", 3);
        SINONIMES.put("дш", 3);
        //SINONIMES.put("шар", 3);
        SINONIMES.put("par38", 4);
        SINONIMES.put("пар38", 4);
        SINONIMES.put("par56", 5);
        SINONIMES.put("пар56", 5);
        SINONIMES.put("e50", 6);
        SINONIMES.put("е50", 6);
        SINONIMES.put("гриб", 6);
        SINONIMES.put("r50", 7);
        SINONIMES.put("р50", 7);
        SINONIMES.put("nr50", 7);
        SINONIMES.put("r63", 8);
        SINONIMES.put("nr63", 8);
        SINONIMES.put("р63", 8);
        SINONIMES.put("r80", 9);
        SINONIMES.put("nr80", 9);
        SINONIMES.put("р80", 9);
        SINONIMES.put("HPI-T", 10);
        SINONIMES.put("HQI-T", 10);
        SINONIMES.put("HPI", 11);
        SINONIMES.put("HQI-E", 11);
        SINONIMES.put("HQI-E", 11);//?

        SINONIMES.put("hwl", 12);
        SINONIMES.put("ml", 12);
        SINONIMES.put("дрв", 12);
        //ho fh lh
        //SINONIMES.put("TL5", 99);

        SINONIMES.put("днат", 13);
        SINONIMES.put("nav-t", 13);
        SINONIMES.put("son-t", 13);

        SINONIMES.put("hql", 14);
        SINONIMES.put("дрл", 14);
        SINONIMES.put("hpl", 14);
        SINONIMES.put("hpl-n", 14);
        SINONIMES.put("pl-s", 15);
        SINONIMES.put("pl-c", 16);
        SINONIMES.put("pl-l", 17);
        SINONIMES.put("TWIST", 18);
        SINONIMES.put("TORNADO", 18);
        SINONIMES.put("MR16", 19);
        SINONIMES.put("MR11", 20);
        SINONIMES.put("ple-c", 21);
        SINONIMES.put("cdm-t", 22);
        SINONIMES.put("hci-t", 22);
        SINONIMES.put("mhn-td", 23);
        SINONIMES.put("cdm-td", 23);
        SINONIMES.put("mhw-td", 23);
        //SINONIMES.put("hqi-ts", 23);
        //SINONIMES.put("CONCENTRA", 99);
        //SINONIMES.put("дсмл", 99);
        //SINONIMES.put("cdm-tc", 21);/
////SINONIMES.put("cdm-r991", 99);
        //SINONIMES.put("ДРИ", 99);
//        SINONIMES.put("HALOLINE", 99);
//        SINONIMES.put("HaloStar", 99);//
//        SINONIMES.put("MR99", 99);
//        SINONIMES.put("HALOLUX", 99);
//        SINONIMES.put("duluxstar", 99);
//        SINONIMES.put("SPC", 99);
//        SINONIMES.put("FL - трубка", 99);
//        SINONIMES.put("FT4", 99);
//        SINONIMES.put("FT5", 99);

    }

    public static Item addBulbType(Item item) {
try{
        String[] words = item.getWords();
        for (int i = 0; i < words.length; i++) {
            if (SINONIMES.get(words[i].toLowerCase()) != null) {
                item.setBulbType(SINONIMES.get(words[i].toLowerCase()));
                return item;
            }
        }}catch (Exception e){item.setBulbType(-1);}
        return item;
    }
} 