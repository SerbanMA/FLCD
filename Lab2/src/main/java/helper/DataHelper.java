package main.java.helper;

import main.java.helper.iostream.ReaderHelper;

import java.util.ArrayList;
import java.util.List;

public abstract class DataHelper {

    private final List<String> separators;
    private final List<String> operators;
    private final List<String> reservedWords;

    public DataHelper() {
        separators = ReaderHelper.readSeparators();
        operators = ReaderHelper.readOperators();
        reservedWords = ReaderHelper.readReservedWords();
    }

    protected List<String> getSeparators() {
        return separators;
    }

    protected List<String> getSeparatorsWithSpecial() {
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

    protected List<String> getOperators() {
        return operators;
    }

    protected List<String> getReservedWords() {
        return reservedWords;
    }

    private boolean isSpecial(String value) {
        return List.of("[", "]", "{", "}").contains(value);
    }
}