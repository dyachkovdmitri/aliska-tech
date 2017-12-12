package com.neiron.neiron.utils.aliska;

import com.neiron.neiron.betweenAttributes.*;
import com.neiron.neiron.crud.ListComment;
import com.neiron.neiron.entities.Item;
import com.neiron.neiron.entities.RequestLine;
import com.neiron.neiron.searchInPrice.SearchInPrice;
import com.neiron.neiron.sinonimes.*;
import com.neiron.neiron.standartValues.StandartWattage;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.neiron.neiron.sinonimes.KelvinSinonimes.addKelvin;

@Service
public class AliskaParser {
    @Autowired
    RegExpParser regExpParser;
    @Autowired
    SearchInPrice searchInPrice;

    public ListComment<RequestLine> parse(ArrayList<RequestLine> lines, Boolean brandImportant) {
        Float accuracy = 0f;
        Long i = 0l;
        for (RequestLine requestLine : lines) {
            i++;
            Item item = parseLine(null, requestLine.getUnparsedLine());
            requestLine.setParsedLine(item.toString());
            requestLine.setAccuracy(item.getAccuracy());
            if (!brandImportant) {
                item.setBrand(null);
            }
            accuracy += item.getAccuracy();
            requestLine.setAssortmentId(searchInPrice.getSimilarItemInPrice(item));
            requestLine.setOrderNumber(i);

        }
        ListComment<RequestLine> result = new ListComment<>();
        result.setData(lines);
        try {
            result.addAliskaMonolog(" Средняя точность при парсинге строк составила " + ((Float) (accuracy / lines.size())).toString().substring(0, 3) + ".");
        } catch (Exception e) {
            result.addAliskaMonolog(" Средняя точность при парсинге строк составила " + accuracy / lines.size() + ".");
        }

        return result;
    }

    public ArrayList<Item> parsePrice(Long priceId, ArrayList<RequestLine> lines, Long customerAliskaId) {
        ArrayList<Item> items = new ArrayList<>();
        for (RequestLine requestLine : lines) {
            Item item = parseLine(priceId, requestLine.getUnparsedLine());
            item.setPrice(requestLine.getPrice());
            item.setAmmount((long)requestLine.getAmmount());
            items.add(item);
        }
        outputExactOfParsing(items);
        return items;

    }

    private void outputExactOfParsing(ArrayList<Item> items) {
        Float count = 0f;
        for (int i = 0; i < items.size(); i++) {
            count += items.get(i).getAccuracy();
        }
        System.out.println("AVERAGE-ACCURACY=" + count / items.size());
    }


    public Item parseLine(Long companyId, String unparsedLine) {
        Item item = new Item();
        item.setPriceId(companyId);

        item.setUnparsedLine(unparsedLine);
        item.setWords(unparsedLine.toLowerCase().replace("/", " ").replace("\"", " ").replace("(", " ").replace(")", " ").split(" "));
        item = firstParse(item);
        item = secondParse(item);
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
        item = addType1(item); //todo делать статические импорты
        item = addKelvin(item);
        item = useTypeTree(item);
        item = useDependenciesBetweenAttributes(item);
//        item = useTypeTree(item);
//        item = useDependenciesBetweenAttributes(item);
        return item;
    }

    private Item useDependenciesBetweenAttributes(Item item) {
        Type4Attribute.findType4ByAnotherAttributes(item);
        Type5Attribute.findType5ByAnotherAttributes(item);
        Type3Attribute.findType3ByAnotherAttributes(item);
        Type2Attribute.findType2ByAnotherAttributes(item);
        BulbTypeAttribute.findBulbTypeByAnotherAttributes(item);
        ConnectorTypeAttribute.findConnectorTypeByAnotherAttributes(item);
        return item;
    }

    private Item secondParse(Item item) {
        item.setWords(item.getUnparsedLine().replace("-", " ").replace("/", " ").replace("(", " ").replace(")", " ").replace(",", " ").replace(".", " ").split(" "));
        if (item.getWattage() == null) {
            item = addWattage(item);
        }

        if (item.getVoltage() == null) {
            item = addVoltage(item);
        }
        if (item.getType5() == null) {
            item = addType5(item);
        }
        if (item.getType4() == null) {
            item = addType4(item);
        }
        if (item.getType3() == null) {
            item = addType3(item);
        }
        if (item.getType2() == null) {
            item = addType2(item);
        }
        if (item.getType1() == null) {
            item = addType1(item);
        }
        if (item.getConnectorType() == null) {
            item = addConnector(item);
        }

        if (item.getBulbType() == null) {
            item = addBulbType(item);
        }
        if (item.getWattage() == null) {
            item = StandartWattage.findStandartWattage(item);
        }
        if (item.getKelvin() == null) {
            item = addKelvin(item);
        }
        item = useTypeTree(item);
        item = useDependenciesBetweenAttributes(item);
//        item = useTypeTree(item);
//        item = useDependenciesBetweenAttributes(item);
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