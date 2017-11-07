package com.neiron.neiron.betweenAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class Type3Attribute {
    public final static HashMap<String, Integer> dependencies = new HashMap<>();

    static {
        dependencies.put("connectorType=9", 1); //галоген
        dependencies.put("connectorType=12", 1); //галоген
        dependencies.put("connectorType=14", 1); //галоген
        //dependencies.put("connectorType=19", 1); //галоген
        //dependencies.put("connectorType=20", 1); //галоген
        //dependencies.put("connectorType=21", 1); //галоген
        dependencies.put("connectorType=30", 1); //галоген
        dependencies.put("bulbType=19", 1); //галоген
        dependencies.put("bulbType=20", 1); //галоген
        dependencies.put("bulbType=29", 1); //галоген
        //dependencies.put("bulbType=29", 1); //галоген
        dependencies.put("bulbType=23", 4); //металлоглоген
        dependencies.put("bulbType=10", 4); //металлоглоген
        dependencies.put("bulbType=11", 4); //металлоглоген
        dependencies.put("bulbType=24", 4); //металлоглоген
        dependencies.put("bulbType=22", 4); //металлоглоген
        dependencies.put("connectorType=11", 4); //металлоглоген




    }

    public static Item findType3ByAnotherAttributes(Item item) {
        if (item.getType3() == null) {
            item.setType3(findStandartWattages(item));
        }
        return item;
    }

    private static Integer findStandartWattages(Item item) {
        for (HashMap.Entry entry : dependencies.entrySet()) {
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
                    return (Integer.parseInt(entry.getValue().toString()));
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