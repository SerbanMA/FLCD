package main.java.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ParseHelper {

    private final DataHelper dataHelper = new DataHelper();

    private final String separatorsRegex = String.join("|", dataHelper.getSeparators());
    private final String operatorsRegex = String.join("|", dataHelper.getOperators());

    public ParseHelper() {}

    public ArrayList<String> parse(File file) {
        ArrayList<String> tokens = new ArrayList<>();

        try {
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine())
                tokens.addAll(parseLine(myReader.nextLine()));

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        return tokens;
    }

    private ArrayList<String> parseLine(String value) {
        return splitWithSeparators(String.join(" ", splitWithOperators(value)));
    }

    private ArrayList<String> splitWithOperators(String value) {
        return Pattern.compile("(?<=(" + operatorsRegex + "))|(?=(" + operatorsRegex + "))")
                .splitAsStream(value)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<String> splitWithSeparators(String value) {
        List<String> stringList = Pattern.compile(separatorsRegex.toString())
                .splitAsStream(value)
                .collect(Collectors.toList());

        return stringList.stream().
                filter(element -> !element.isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
