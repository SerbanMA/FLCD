package main.java;

import main.java.domain.Pair;
import main.java.helper.ParseHelper;
import main.java.helper.RegexHelper;

import java.io.File;
import java.util.ArrayList;

public class Scanner {

    private final SymbolTable identifiersTable = new SymbolTable();
    private final SymbolTable constantsTable = new SymbolTable();
    private final ArrayList<Pair> pifList = new ArrayList<>();

    private final RegexHelper regexHelper = new RegexHelper();
    private final ParseHelper parseHelper = new ParseHelper();

    public Scanner () {}

    public void scan (File file) {
        System.out.println(file);
    }
}
