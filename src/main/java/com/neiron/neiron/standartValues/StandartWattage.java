package com.neiron.neiron.standartValues;

import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class StandartWattage {
    public final static HashMap<String, String> standartWattages = new HashMap<>();

    static {
        standartWattages.put("connectorType=4", "18 36 58"); //g13
        standartWattages.put("connectorType=10", "35 70 150"); //g12
        standartWattages.put("connectorType=18", "20 20 40");//g5
        standartWattages.put("connectorType=11", "35 70 150");//rx7s
        standartWattages.put("connectorType=1, type2=1", "25, 40, 60, 75");

        private Item findStandartWattages (Item item)
        {

        }
    }