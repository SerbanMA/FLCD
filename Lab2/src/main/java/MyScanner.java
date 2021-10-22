package main.java;

import main.java.domain.Pair;
import main.java.helper.DataHelper;
import main.java.helper.ParseHelper;
import main.java.helper.RegexHelper;

import java.io.File;
import java.util.ArrayList;

public class MyScanner {

    private SymbolTable identifiersTable;
    private SymbolTable constantsTable;
    private ArrayList<Pair> pifList;

    private final ParseHelper parseHelper = new ParseHelper();
    private final RegexHelper regexHelper = new RegexHelper();
    private final DataHelper dataHelper = new DataHelper();

    public MyScanner() {
        set();
    }

    public void scan(File file) {
        set();

        ArrayList<String> tokens = parseHelper.parse(file);

        tokens.forEach(() -> {
            asd
        });

        System.out.println(tokens);
    }

    public void print() {

    }

    private void set() {
        identifiersTable = new SymbolTable();
        constantsTable = new SymbolTable();
        pifList = new ArrayList<>();
    }
}
