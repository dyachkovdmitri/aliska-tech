package com.neiron.neiron.betweenAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neiron.neiron.entities.Item;

import java.util.HashMap;

public class ConnectorTypeAttribute {
    public final static HashMap<String, Integer> dependencies = new HashMap<>();

    static {
        dependencies.put("bulbType=27", 4);//g13
        dependencies.put("bulbType=29", 12);//r7s
        dependencies.put("bulbType=7", 2);//r7s
        dependencies.put("bulbType=8", 1);//r7s
        dependencies.put("bulbType=9", 1);//r7s
//        dependencies.put("bulbType=13", 3);

    }
    public static Item findConnectorTypeByAnotherAttributes(Item item) {
        if(item.getConnectorType()==null){
        item.setConnectorType(useDependencies(item));}
        return item;
    }
    private static Integer useDependencies(Item item) {
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