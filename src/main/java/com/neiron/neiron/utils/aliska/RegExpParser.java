package com.neiron.neiron.utils.aliska;

import com.neiron.neiron.entities.Item;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
class RegExpParser {


    private Integer getWattage(String word) {
        try {
            String wordLC = word.toLowerCase();
            Pattern p = Pattern.compile("^(\\d\\d|\\d|\\d\\d\\d|\\d\\d\\d\\d)(ватт|вт|w)$");
            Matcher m = p.matcher(wordLC);
            if (m.matches()) {
                wordLC = wordLC.replace("ватт", "").replace("вт", "").replace("w", "");
                return Integer.parseInt(wordLC);
            } else return null;
        } catch (Exception e) {
            System.out.println("WARTAGE ERROR2"+word);
            return null;
        }
    }

    private Boolean getSeparatedWattage(String word) {
        return (word.equalsIgnoreCase("ватт")) || (word.equalsIgnoreCase("вт")) || (word.equalsIgnoreCase("w"));
    }

    private Boolean getSeparatedVoltage(String word) {
        return (word.equalsIgnoreCase("вольт")) || (word.equalsIgnoreCase("в")) || (word.equalsIgnoreCase("v"));
    }

    private Integer getVoltage(String word) {
        try {
            String wordLC = word.toLowerCase();
            Pattern p = Pattern.compile("^(\\d\\d|\\d|\\d\\d\\d|\\d\\d\\d\\d)(вольт|в|v)$");
            Matcher m = p.matcher(wordLC);
            if (m.matches()) {
                wordLC = wordLC.replace("вольт", "").replace("в", "").replace("v", "");
                return Integer.parseInt(wordLC);
            } else return null;
        } catch (Exception e) {
            System.out.println("VOLTAGE ERROR2"+ word);
            return null;

        }
    }

    Item addWattage(Item item) {
        try {
            String[] words = item.getWords();
            Integer wattage = null;
            for (int i = 0; i < words.length; i++) {
                wattage = getWattage(words[i]);
                if (wattage != null) {
                    item.setWattage(wattage);
                }
                if (getSeparatedWattage(words[i])) {
                    item.setWattage(Integer.parseInt(words[i-1].replace("-", "").replace("/", "").replace("(", "").replace(")", "").replace(",", "").replace(".", "")));
                }
            }
        } catch (Exception e) {
            item.setWattage(null);
            System.out.println("VATTAGE ERROR"+ item.getUnparsedLine());
        }
        return item;
    }

    Item addVoltage(Item item) {
        item = addVoltage2(item);
        if(item.getVoltage()!=null&&item.getVoltage()>200&&item.getVoltage()<260){
            item.setVoltage(220);
        }
        return item;
    }

    Item addVoltage2(Item item) {
        try {
            String[] words = item.getWords();
            Integer voltage = null;
            for (int i = 0; i < words.length; i++) {
                voltage = getVoltage(words[i]);
                if (voltage != null) {
                    if (voltage == 0) {
                        item.setVoltage(Integer.parseInt(words[i - 1]));
                    }
                    item.setVoltage(voltage);
                    return item;
                }
                if (getSeparatedVoltage(words[i])) {
                    item.setVoltage(Integer.parseInt(words[i - 1].replace("-", "").replace("/", "").replace("(", "").replace(")", "").replace(",", "").replace(".", "")));
                }
            }
        } catch (Exception e) {
            item.setVoltage(null);
            System.out.println("VOLTAGE ERROR" + item.getUnparsedLine());
        }
        return item;
    }
}
