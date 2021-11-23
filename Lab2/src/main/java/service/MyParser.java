package main.java.service;

import main.java.domain.Configuration;
import main.java.domain.Rule;
import main.java.helper.constants.Constant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class MyParser {

    private final String FINAL = "f";
    private final String ERROR = "e";
    private final String BACK = "b";
    private final String NORMAL = "q";


    public void recursiveDescendant(MyGrammar grammar, String input) {

        try {

            FileWriter fileWriter = new FileWriter(Constant.output + "debug");
            BufferedWriter writer = new BufferedWriter(fileWriter);

            Configuration configuration = new Configuration(grammar.getStartSymbol());

            while (!Objects.equals(configuration.getState(), FINAL) &&
                    !Objects.equals(configuration.getState(), ERROR)) {
                writer.write("################\n");
                writer.write("INPUT: " + configuration.getInputStack() + "\n");
                writer.write("WORK: " + configuration.getWorkStack() + "\n");
                writer.write("STATE: " + configuration.getState() + "\n");
                writer.write("INDEX: " + configuration.getIndex() + "\n");

                if (Objects.equals(configuration.getState(), NORMAL)) {

                    if (configuration.getInputStack().isEmpty() && configuration.getIndex() == input.length()) {
                        SUCCESS(configuration);
                    }

                    else if (configuration.getInputStack().isEmpty()){
                        BACK(configuration);
                    }

                    else {
                        // EXPEND CASE
                        if (grammar.getNonTerminalSymbols().contains(configuration.getInputStack().get(0))) {
                            String nonTerminal = configuration.getInputStack().get(0);
                            writer.write("EXPAND: " + nonTerminal + "\n");
                            String firstProduction = grammar.getProductionsByKey(nonTerminal).get(0);

                            configuration.getWorkStack().push(new Rule(nonTerminal, firstProduction));
                            configuration.getInputStack().add(0, firstProduction);
                        }
                        else {
                            if (configuration.getIndex() == input.length()) {
                                // Momentary insuccess
                                configuration.setState(BACK);
                                writer.write("BACK\n");
                            }
                            else if (Objects.equals(configuration.getInputStack().get(0), ERROR)) {
                                //configuration.getWorkStack().
                            }
                        }
                    }
                }



            }
            writer.close();

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void SUCCESS(Configuration configuration) {
        configuration.setState("f");
    }

    private void BACK(Configuration configuration) {
        configuration.setState("b");
    }
}
