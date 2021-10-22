package main.java.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ParseHelper extends DataHelper{

    private final String separatorsRegex = String.join("|", getSeparatorsWithSpecial());
    private final String operatorsRegex = String.join("|", getOperators());

    public ParseHelper() {}

    public ArrayList<String> parseLine(String value) {
        return splitWithSeparators(String.join(" ", splitWithOperators(value)));
    }

    private ArrayList<String> splitWithOperators(String value) {
        return Pattern.compile("(?<=(" + operatorsRegex + "))|(?=(" + operatorsRegex + "))")
                .splitAsStream(value)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<String> splitWithSeparators(String value) {
        List<String> stringList = Pattern.compile("(?<=(" + separatorsRegex + "))|(?=(" + separatorsRegex + "))")
                .splitAsStream(value)
                .collect(Collectors.toList());

        return stringList.stream().
                filter(element -> !element.isBlank())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
