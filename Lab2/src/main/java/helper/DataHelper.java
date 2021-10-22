package main.java.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataHelper {

    private final ArrayList<String> separators = new ArrayList<>();
    private final ArrayList<String> operators = new ArrayList<>();
    private final ArrayList<String> reservedWords = new ArrayList<>();

    public DataHelper() {
        readSeparators();
        readOperators();
        readReservedWords();
        System.out.println(reservedWords);
    }

    public ArrayList<String> getSeparators() {
        return separators;
    }

    public ArrayList<String> getOperators() {
        return operators;
    }

    public ArrayList<String> getReservedWords() {
        return reservedWords;
    }

    private void readSeparators() {
        try {
            File myObj = new File("src/resources/files/input/separators.ini");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String separator = myReader.nextLine();
                separators.add(separator);
            }

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void readOperators() {
        try {
            File myObj = new File("src/resources/files/input/operators.ini");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String operator = myReader.nextLine();
                operators.add(operator);
            }

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void readReservedWords() {
        try {
            File myObj = new File("src/resources/files/input/res_words.ini");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String operator = myReader.nextLine();
                reservedWords.add(operator);
            }

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
