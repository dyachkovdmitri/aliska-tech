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
        outputExactOfParsing(items);
        return items;

    }

    private void outputExactOfParsing(ArrayList<Item> items) {

        Integer count = 0;
        Integer countVoltage = 0;
        Integer countWattage = 0;
        Integer countConnectorType = 0;
        Integer countBrand = 0;
        Integer countBulbType = 0;
        Integer countType1 = 0;
        Integer countType2 = 0;
        Integer countType3 = 0;
        Integer countType4 = 0;
        Integer countType5 = 0;
        for (Item item : items) {
            Integer exact = 0;
            if (item.getType5() != null) {
                count++;
                countType5++;
            }
            if (item.getType4() != null) {
                count++;
                countType4++;
            }
            if (item.getType3() != null) {
                count++;
                countType3++;
            }
            if (item.getType2() != null) {
                count++;
                countType2++;
            }
            if (item.getType1() != null) {
                count++;
                countType1++;
            }
            if (item.getConnectorType() != null) {
                count++;
                countConnectorType++;
                exact++;
            }
            if (item.getWattage() != null) {
                count++;
                countWattage++;
                exact++;
            }
            if (item.getBrand() != null) {
                count++;
                countBrand++;
            }
            if (item.getBulbType() != null) {
                count++;
                countBulbType++;
                exact++;
            }
            if (item.getVoltage() != null) {
                count++;
                countVoltage++;
                exact++;
            }

            if (item.getWattage() == null) {
                System.out.println(item.getUnparsedLine() + " ----- " + exact);
            }
        }
        System.out.println("!!!!!!!!ПРОЦЕНТ РАСПАРШЕННОСТИ!!!!!!!");
//        System.out.println("countType5: "+ countType5/items.size());
//        System.out.println("countType4: "+ countType4/items.size());
//        System.out.println("countType2: "+ countType3/items.size());
//        System.out.println("countType2: "+ countType2/items.size());
//        System.out.println("countType1: "+ countType1/items.size());
//        System.out.println("countBulbType: "+ countBulbType/items.size());
//        System.out.println("countBrand: "+ countBrand/items.size());
//        System.out.println("countConnectorType: "+ countConnectorType/items.size());
//        System.out.println("countBulbType: "+ countWattage/items.size());
//        System.out.println("countVoltage: "+ countVoltage/items.size());
//        System.out.println("Общий: "+ count/items.size()/10);
//
//        System.out.println("!!!!!!!ВСЕГО РАСПАРШЕННОСТИ!!!!!!!");
//        System.out.println("countType5: "+ countType5);
//        System.out.println("countType4: "+ countType4);
//        System.out.println("countType3: "+ countType3);
//        System.out.println("countType2: "+ countType2);
//        System.out.println("countType1: "+ countType1);
        System.out.println("countBulbType: "+ countBulbType);
       // System.out.println("countBrand: "+ countBrand);
        System.out.println("countConnectorType: " + countConnectorType);
        System.out.println("countWattage: "+ countWattage);
        System.out.println("countVoltage: "+ countVoltage);
        System.out.println("Общий: "+ items.size());
    }

    private Item parseLine(Long companyId, String unparsedLine) {
        // if(unparsedLine.equals("")){System.out.print("Ошибка! ");}
        Item item = new Item();
        item.setCompanyId(companyId);

        item.setUnparsedLine(unparsedLine);
        item.setWords(unparsedLine.toLowerCase().replace("/", " ").replace("(", " ").replace(")", " ").split(" "));
        item = firstParse(item);
        item = secondParse(item);
        //System.out.println(item);
        return item;
    }

    private Item firstParse(Item item) {
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
        //System.out.println(item);
        return item;
    }

    private Item secondParse(Item item) {
        item.setWords(item.getUnparsedLine().replace("-", " ").replace("/", " ").replace("(", " ").replace(")", " ").split(" "));
        if (item.getWattage() == null) {
            item = addWattage(item);
        }
        if (item.getVoltage() == null) {
            item = addVoltage(item);
        }
        if (item.getConnectorType() == null) {
            item = addConnector(item);
        }

        //System.out.println(item);
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