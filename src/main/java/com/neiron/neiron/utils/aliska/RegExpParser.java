package com.neiron.neiron.utils.aliska;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpParser {
    public static Integer getWattage(String word) {
        Pattern p = Pattern.compile("^\\\\d|\\\\d\\\\d|\\\\d\\\\d\\\\d\\\\d|\\\\d\\\\d\\\\dW|w|Вт|вт|ватт$");
        Matcher m = p.matcher(word);
        return Integer.parseInt(word.substring(0,word.length()));
    }

    public static Integer getVoltage(String word) {
        Pattern p = Pattern.compile("^\\\\d|\\\\d\\\\d|\\\\d\\\\d\\\\d\\\\d|\\\\d\\\\d\\\\dV|v|вольт|Вольт$");
        Matcher m = p.matcher(word);
        return Integer.parseInt(word.substring(0,word.length()));
    }
}