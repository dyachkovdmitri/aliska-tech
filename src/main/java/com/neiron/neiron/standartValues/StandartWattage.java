package com.neiron.neiron.standartValues;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.*;
import com.neiron.neiron.entities.Item;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSONFunctions;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;

public class StandartWattage {
    public final static HashMap<String, String> standartWattages = new HashMap<>();

    static {
        standartWattages.put("connectorType=4", "18, 36, 58"); //g13
        standartWattages.put("connectorType=10", "35, 70, 150"); //g12
        standartWattages.put("connectorType=18", "20, 20, 40");//g5
        standartWattages.put("connectorType=11", "35, 70, 150");//rx7s
        standartWattages.put("connectorType=1, type2=1", "25, 40, 60, 75"); //лампы накаливания
    }

    public static Item findStandartWattage(Item item) {
        String standartWattages = findStandartWattages(item);
        if(standartWattages!=null){
        String[] wattages = findStandartWattages(item).split(", ");
        for (int i = 0; i < wattages.length; i++) {
            for (int j = 0; j < item.getWords().length; j++)
                if (wattages[i].equals(item.getWords()[j])) {
                    item.setWattage(Integer.parseInt(wattages[i]));
                    return item;
                }
        }}
        return item;
    }


    private static String findStandartWattages(Item item) {
        ArrayList<String> result = new ArrayList<>();
        for (HashMap.Entry entry : standartWattages.entrySet()) {
            String key = entry.getKey().toString();
            String[] attributes = key.split(", ");
            Integer countAttributes = 0;
            for (int i = 0; i < attributes.length; i++) {
                String[] attributeValue = attributes[i].split("=");
                if (getAttributeFromItem(item, attributeValue[0]).equals(attributeValue[1])) {
                    countAttributes++;
                }
                if (countAttributes.equals(attributes.length)) {
                    //System.out.println("GETSTANDARTWATTAGES " + item.getUnparsedLine() + "====" + item.toString() + "==" + entry.getValue());
                    return (entry.getValue().toString());
                }
            }
        }
        return null;
    }


    private static String getAttributeFromItem(Item item, String attributeName) {
        JsonParser parser = new JsonParser();
        Gson gson = new Gson();
        JsonElement jItem = parser.parse(gson.toJson(item));
        JsonObject rootObject = jItem.getAsJsonObject();
        JsonElement jElement = rootObject.get(attributeName);
        if (jElement != null) {
            return jElement.getAsString();
        } else return "dsavbgt43";
    }
}