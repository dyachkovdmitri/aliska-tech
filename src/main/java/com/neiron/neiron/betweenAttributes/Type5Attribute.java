package com.neiron.neiron.betweenAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neiron.neiron.entities.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Type5Attribute {
    public final static HashMap<String, Integer> standartWattages = new HashMap<>();

    static {
        standartWattages.put("bulbType=14", 1); //g13=
        //dependencies.put("BulbTypeAttribute=13", 3); //днат
        standartWattages.put("bulbType=28", 2);//клл

    }

    public static Item findType5ByAnotherAttributes(Item item) {
        if (item.getType5() == null) {
            item.setType5(findStandartWattages(item));
        }
        return item;
    }

    private static Integer findStandartWattages(Item item) {
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