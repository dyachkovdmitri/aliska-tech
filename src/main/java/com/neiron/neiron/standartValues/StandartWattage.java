package com.neiron.neiron.standartValues;

import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class StandartWattage {
    public final static HashMap<String, String> standartWattages = new HashMap<>();

    static {
        standartWattages.put("connectorType=1", "20 20 40");}

    private Item findStandartWattages(Itesm item)
    {

    }
} 