package main.java.service;

import main.java.domain.Rule;
import main.java.helper.constants.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MyGrammar {
    private Set<String> nonTerminalSymbols;
    private Set<String> terminalSymbols;
    private final Set<Rule> rules = new HashSet<>();
    private String startSymbol;

    public MyGrammar(String fileName) {
        readData(fileName);
    }

    public Set<String> getNonTerminalSymbols() {
        return nonTerminalSymbols;
    }

    public Set<String> getTerminalSymbols() {
        return terminalSymbols;
    }

    public Set<Rule> getRules() {
        return rules;
    }

    public String getStartSymbol() {
        return startSymbol;
    }

    public Set<String> getProductionsByKey(String key) {
        return rules.stream()
                .filter(rule -> Objects.equals(rule.getKey(), key))
                .map(Rule::getValue)
                .collect(Collectors.toCollection(HashSet::new));
    }

    private void readData(String fileName) {

        File file = new File(Constant.input + fileName);
        try {
            Scanner myReader = new Scanner(file);

            nonTerminalSymbols = Pattern.compile(",")
                    .splitAsStream(myReader.nextLine())
                    .map(String::strip)
                    .collect(Collectors.toCollection(HashSet::new));

            terminalSymbols = Pattern.compile(",")
                    .splitAsStream(myReader.nextLine())
                    .map(String::strip)
                    .collect(Collectors.toCollection(HashSet::new));

            String[] rule = myReader.nextLine().split("->");
            while (rule.length == 2) {
                String[] productions = rule[1].split("\\|");
                for (String production : productions) {
                    rules.add(new Rule(rule[0].strip(), production.strip()));
                }

                rule = myReader.nextLine().split("->");
            }

            startSymbol = rule[0];

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isContextFree() {
        if (rules.isEmpty())
            return false;

        return rules.stream()
                .filter(rule -> !nonTerminalSymbols.contains(rule.getKey()))
                .collect(Collectors.toCollection(HashSet::new))
                .isEmpty();
    }

    @Override
    public String toString() {
        return "MyGrammar{" +
                "nonTerminalSymbols=" + nonTerminalSymbols +
                ", terminalSymbols=" + terminalSymbols +
                ", rules=" + rules +
                ", startSymbol='" + startSymbol + '\'' +
                '}';
    }
}
