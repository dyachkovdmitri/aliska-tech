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
        standartWattages.put("connectorType=18", "20, 40");//g5
        standartWattages.put("bulbType=7", "25, 40, 60");//r50
        standartWattages.put("bulbType=2", "25, 40, 60");//r50
        standartWattages.put("bulbType=3", "25, 40, 60");//r50
        standartWattages.put("bulbType=8", "25, 40, 60");//r50
        standartWattages.put("connectorType=11", "35, 70, 150");//rx7s
        standartWattages.put("connectorType=1", "25, 40, 60, 75");
        standartWattages.put("connectorType=2", "25, 40, 60");//лампы накаливания
        standartWattages.put("type4=1", "160, 125, 400, 250, 700, 1000"); //дрл
        standartWattages.put("bulbType=14", "160, 250, 125, 400, 700, 1000");
        standartWattages.put("type4=3", "70, 150, 250, 400"); //днат
        standartWattages.put("type3=4", "250, 400, 700, 1000"); //дри
        standartWattages.put("bulbType=29", "500, 1000, 1500, 2000, 5000"); //дри
        standartWattages.put("bulbType=12", "160, 250, 500"); //дри
        standartWattages.put("connectorType=12", "500, 1000, 1500, 2000, 5000");
        standartWattages.put("type5=1, connectorType=1", "11, 15, 18, 20, 25");//клл
        standartWattages.put("type5=1, connectorType=2", "11, 15, 18, 20, 25");//клл

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