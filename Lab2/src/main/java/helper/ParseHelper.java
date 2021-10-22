package main.java.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ParseHelper {

    List<String> specials = List.of("/", ".", "*", "+", "?", "|", "(", ")", "[", "]", "{", "}", "\\");

    private final StringBuilder separatorsRegex = new StringBuilder();
    private final StringBuilder operatorsRegex = new StringBuilder();

    public ParseHelper() {
        readSeparators();
        readOperators();
    }

    public ArrayList<String> parse(String value) {
        return splitWithSeparators(String.join(" ", splitWithOperators(value)));
    }


    public ArrayList<String> splitWithOperators (String value) {
        return Pattern.compile("(?<=(" + operatorsRegex + "))|(?=(" + operatorsRegex + "))")
                .splitAsStream(value)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<String> splitWithSeparators (String value) {
        List<String> stringList = Pattern.compile(separatorsRegex.toString())
                .splitAsStream(value)
                .collect(Collectors.toList());

        return stringList.stream().
                filter(element -> !element.isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void readSeparators () {

        try {
            File myObj = new File("src/resources/files/input/separators.ini");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine())
                separatorsRegex.append("|").append(myReader.nextLine());

            separatorsRegex.deleteCharAt(0);

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void readOperators () {

        try {
            File myObj = new File("src/resources/files/input/operators.ini");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine())
                operatorsRegex.append("|").append(myReader.nextLine());

            operatorsRegex.deleteCharAt(0);

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void main(String[] args) {
        ParseHelper parseHelper = new ParseHelper();


        System.out.println(parseHelper.parse("anaandmaria<= [[[[ mere   ;eu~~tu[][+1 \n maria <-2add7 "));
    }
}
