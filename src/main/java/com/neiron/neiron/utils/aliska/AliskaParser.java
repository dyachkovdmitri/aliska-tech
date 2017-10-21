package com.neiron.neiron.utils.aliska;

import com.neiron.neiron.entities.Item;
import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.sinonimes.BrandSinonimes;
import com.neiron.neiron.sinonimes.BulbColorSinonimes;
import com.neiron.neiron.sinonimes.BulbTypeSinonimes;
import com.neiron.neiron.sinonimes.ConnectorSinonimes;
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
        for (RequestLine requestLine : lines) {
            requestLine.setParsedLine(parseLine(requestLine.getUnparsedLine()));
        }
        return lines;
    }

    private String parseLine(String unparsedLine) {
        Item item = new Item();
        item.setUnparsedLine(unparsedLine);
        item = addWattage(item);
        item = addVoltage(item);
        item = addConnector(item);
        item = addBulbColor(item);
        item = addBulbType(item);
        item = addBrand(item);
        System.out.println(item);
        return item.toString();
    }

    private Item addWattage(Item item) {
        return regExpParser.addWattage(item);
    }

    private Item addVoltage(Item item) {
        return regExpParser.addVoltage(item);
    }

    private Item addConnector(Item item) {
        return ConnectorSinonimes.addConnector(item);
    }
    private Item addBulbColor(Item item) {
        return BulbColorSinonimes.addBulbColor(item);
    }
    private Item addBulbType(Item item) {
        return BulbTypeSinonimes.addBulbType(item);
    }
    private Item addBrand(Item item) {
        return BrandSinonimes.addBrand(item);
    }
}