package com.neiron.neiron.betweenAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neiron.neiron.entities.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Type4Attribute {
    public final static HashMap<String, Integer> dependencies = new HashMap<>();

    static {
        dependencies.put("bulbType=14", 1); //g13=
        dependencies.put("bulbType=13", 3);
        dependencies.put("connectorType=14", 2); //2=ртутные
        dependencies.put("connectorType=4", 2); //2=ртутные
        dependencies.put("connectorType=16", 2); //2=ртутные
        dependencies.put("connectorType=17", 2); //2=ртутные
        dependencies.put("connectorType=18", 2); //2=ртутные
        dependencies.put("connectorType=23", 2); //2=ртутные
        dependencies.put("connectorType=26", 2); //2=ртутные
        dependencies.put("connectorType=27", 2); //2=ртутные
        dependencies.put("connectorType=28", 2); //2=ртутные
        dependencies.put("connectorType=29", 2); //2=ртутные
        dependencies.put("connectorType=31", 2); //2=ртутные
        dependencies.put("connectorType=26", 2); //2=ртутные
        dependencies.put("connectorType=36", 2); //2=ртутные
        dependencies.put("connectorType=37", 2); //2=ртутные
        dependencies.put("connectorType=38", 2); //2=ртутные
        dependencies.put("connectorType=39", 2); //2=ртутные

    }
    public static Item findType4ByAnotherAttributes(Item item) {
        if (item.getType4() == null) {
        item.setType4(findStandartWattages(item));}
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