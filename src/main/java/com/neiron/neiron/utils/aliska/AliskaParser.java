package com.neiron.neiron.utils.aliska;

import com.neiron.neiron.entities.Item;
import com.neiron.neiron.entities.RequestLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AliskaParser {
    @Autowired
    DBParser dbParser;
    @Autowired
    RegExpParser regExpParser;

    public ArrayList<RequestLine> parse(ArrayList<RequestLine> lines) {
        for(RequestLine requestLine:lines){
            requestLine.setParsedLine(parseLine(requestLine.getUnparsedLine()));
        }
        return lines;
    }

    private String parseLine(String unparsedLine) {
        Item item = new Item();
        String[] words = unparsedLine.trim().split(" ");
        for(int i = 0;i<words.length;i++)
        {
            item.setConnectorType(dbParser.getConnectorType(words[i]));
            item.setBulbColor(dbParser.getBulbColor(words[i]));
            item.setBulbType(dbParser.getBulbType(words[i]));
            item.setWattage(regExpParser.getWattage(words[i]));
            item.setVoltage(regExpParser.getVoltage(words[i]));
        }
        return null;
    }
}