package main.java.helper;

import main.java.helper.iostream.ReaderHelper;

import java.util.ArrayList;
import java.util.List;

public abstract class DataHelper {

    private final ArrayList<String> separators;
    private final ArrayList<String> operators;
    private final ArrayList<String> reservedWords;

    public DataHelper() {
        separators = ReaderHelper.readSeparators();
        operators = ReaderHelper.readOperators();
        reservedWords = ReaderHelper.readReservedWords();
    }

    protected ArrayList<String> getSeparators() {
        return separators;
    }

    protected ArrayList<String> getSeparatorsWithSpecial() {
        ArrayList<String> separatorsWithSpecial = new ArrayList<>();

        for (String separator : separators) {

            if (isSpecial(separator)) {
                separatorsWithSpecial.add("\\" + separator);
            } else {
                separatorsWithSpecial.add(separator);
            }
        }
        return separatorsWithSpecial;
    }

    protected ArrayList<String> getOperators() {
        return operators;
    }

    protected ArrayList<String> getReservedWords() {
        return reservedWords;
    }

    private boolean isSpecial(String value) {
        return List.of("[", "]", "{", "}").contains(value);
    }
}
