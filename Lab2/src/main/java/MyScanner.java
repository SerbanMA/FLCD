package main.java;

import main.java.domain.Pair;
import main.java.helper.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyScanner {

    private SymbolTable identifiersTable;
    private SymbolTable constantsTable;
    private ArrayList<Pair> pifList;
    private final StringBuilder messageError = new StringBuilder();

    private final ParseHelper parseHelper = new ParseHelper();
    private final RegexHelper regexHelper = new RegexHelper();
    private final TypeHelper typeHelper = new TypeHelper();

    public MyScanner() {
        set();
    }

    public void scan(File file) {
        set();
        int line = 0;

        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                line += 1;

                ArrayList<String> tokens = parseHelper.parseLine(myReader.nextLine());
                for (String token : tokens) {
                    if (typeHelper.isSeparator(token) || typeHelper.isOperator(token) || typeHelper.isReservedWord(token)) {
                        pifList.add(new Pair(token, 0));
                    } else if (regexHelper.isIdentifier(token)) {
                        Integer index = identifiersTable.add(token);
                        pifList.add(new Pair(token, index));
                    } else if (regexHelper.isConstant(token)) {
                        Integer index = constantsTable.add(token);
                        pifList.add(new Pair(token, index));
                    } else {
                        messageError.append("Error occurred on line ")
                                .append(line)
                                .append(" for token ")
                                .append(token)
                                .append("\n");
                    }
                }
            }
            if (!messageError.isEmpty())
                throw new Exception(messageError.toString());

            printST();
            printPIF();

        } catch (Exception exception) {
            System.out.println(ColourHelper.RED + exception.getMessage().strip() + ColourHelper.RESET);
        }
    }

    public void printST() {
        System.out.println(identifiersTable);
        System.out.println(constantsTable);
    }

    public void printPIF() {
        System.out.println(pifList);
    }

    private void set() {
        identifiersTable = new SymbolTable();
        constantsTable = new SymbolTable();
        pifList = new ArrayList<>();
    }
}
