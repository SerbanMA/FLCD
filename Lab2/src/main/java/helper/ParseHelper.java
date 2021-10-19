package main.java.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParseHelper {

    private final StringBuilder separatorsRegex = new StringBuilder();
    private final StringBuilder operatorsRegex = new StringBuilder();

    public String[] splitWithOperators (String value) {
        return value.split("(?<=(" + operatorsRegex + "))|(?=(" + operatorsRegex + "))");
    }

    public String[] splitWithSeparators (String value) {
        return value.split("(?<=(" + separatorsRegex + "))|(?=(" + separatorsRegex + "))");
    }

    private void readSeparators () {

        try {
            File myObj = new File("src/resources/files/input/separators.ini");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String operator = myReader.nextLine();

                separatorsRegex.append("|").append(operator);
            }
            separatorsRegex.deleteCharAt(0);

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void readOperators () {

        try {
            File myObj = new File("src/resources/files/input/operators.ini");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String operator = myReader.nextLine();

                operatorsRegex.append("|").append(operator);
            }
            operatorsRegex.deleteCharAt(0);

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
