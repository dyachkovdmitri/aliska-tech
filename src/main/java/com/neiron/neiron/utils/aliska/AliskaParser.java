package com.neiron.neiron.utils.aliska;

import com.neiron.neiron.entities.Item;
import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.sinonimes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AliskaParser {
    @Autowired
    RegExpParser regExpParser;

    public ArrayList<RequestLine> parse(ArrayList<RequestLine> lines) {
        for (RequestLine requestLine : lines) {
            requestLine.setParsedLine(parseLine(null, requestLine.getUnparsedLine()).toString());
        }
        return lines;
    }

    public ArrayList<Item> parsePrice(Long companyId, ArrayList<RequestLine> lines) {
        ArrayList<Item> items = new ArrayList<>();
        for (RequestLine requestLine : lines) {
            items.add(parseLine(companyId, requestLine.getUnparsedLine()));
        }
        return items;
    }

    private Item parseLine(Long companyId, String unparsedLine) {
        Item item = new Item();
        item.setCompanyId(companyId);
        item.setUnparsedLine(unparsedLine);
        item = addWattage(item);
        item = addVoltage(item);
        item = addConnector(item);
        item = addBulbColor(item);
        item = addBulbType(item);
        item = addBrand(item);
        item = addType5(item);
        item = addType4(item);
        item = addType3(item);
        item = addType2(item);
        item = addType1(item);
        item = useTypeTree(item);


        System.out.println(item);
        return item;
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

    private Item addType5(Item item) {
        return Type5Sinonimes.addType5(item);
    }

    private Item addType4(Item item) {
        return Type4Sinonimes.addType4(item);
    }

    private Item addType3(Item item) {
        return Type3Sinonimes.addType3(item);
    }

    private Item addType2(Item item) {
        return Type2Sinonimes.addType2(item);
    }

    private Item addType1(Item item) {
        return Type1Sinonimes.addType1(item);
    }

    private Item useTypeTree(Item item) {
        return TypeTree.getTypeTree(item);
    }

}