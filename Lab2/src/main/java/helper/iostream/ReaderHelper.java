package main.java.helper.iostream;

import main.java.helper.constants.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderHelper {

    public static ArrayList<String> readSeparators() {
        ArrayList<String> separators = new ArrayList<>();

        try {
            File file = new File(Constant.input + "separators.ini");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String separator = myReader.nextLine();
                separators.add(separator);
            }

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        return separators;
    }

    public static ArrayList<String> readOperators() {
        ArrayList<String> operators = new ArrayList<>();

        try {
            File file = new File(Constant.input + "operators.ini");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String operator = myReader.nextLine();
                operators.add(operator);
            }

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        return operators;
    }

    public static ArrayList<String> readReservedWords() {
        ArrayList<String> reservedWords = new ArrayList<>();

        try {
            File file = new File(Constant.input + "res_words.ini");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String operator = myReader.nextLine();
                reservedWords.add(operator);
            }

        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        return reservedWords;
    }
}
