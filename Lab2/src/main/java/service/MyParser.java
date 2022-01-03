package main.java.service;

import main.java.domain.Configuration;
import main.java.domain.Production;
import main.java.helper.constants.Constant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

                    if (configuration.getIndex() == input.split(" ").length && configuration.getInputStack().isEmpty()) {
                        SUCCESS(configuration);
                    } else {
                        // IMPORTANT
                        if (configuration.getInputStack().isEmpty()) {
                            MOMENTARY_INSUCCESS(configuration);
                        }
                        else {
                            String head = configuration.getInputStack().get(0);
                            if (grammar.getNonTerminalSymbols().contains(head)) {
                                EXPAND(configuration, grammar);

                            } else {
                                if (configuration.getIndex() < input.length() && Objects.equals(head, input.split(" ")[configuration.getIndex()])) {
                                    ADVANCE(configuration);

                                } else {
                                    MOMENTARY_INSUCCESS(configuration);
                                }
                            }
                        }
                    }

                } else if (Objects.equals(configuration.getState(), BACK)) {
                    String lastProductionKey = configuration.getWorkStack().peek().getKey();

                    if (grammar.getTerminalSymbols().contains(lastProductionKey)) {
                        // BACK
                        BACK(configuration);
                    } else {
                        // ANOTHER TRY
                        ANOTHER_TRY(configuration, grammar);
                    }
                }
            }

            if (Objects.equals(configuration.getState(), ERROR))
                System.out.println("Error");
            else {
                System.out.println("Sequence accepted");

                String result = grammar.getStartSymbol();
                System.out.println(result);

                List<Production> finalProductions = configuration.getWorkStack()
                        .stream()
                        .filter(production -> grammar.getRules().contains(production))
                        .collect(Collectors.toList());

                for (var production : finalProductions) {
                    result = result.replaceFirst(production.getKey(), String.join(" ", production.getValue()));
                    System.out.println(result);
                }
            }

            writer.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void EXPAND(Configuration configuration, MyGrammar grammar) {
        String head = configuration.getInputStack().get(0);
        List<String> firstProduction = grammar.getProductionsByKey(head).get(0);

        configuration.getWorkStack().push(new Production(head, firstProduction));
        configuration.getInputStack().remove(0);
        configuration.getInputStack().addAll(0, firstProduction);
    }

    private void ADVANCE(Configuration configuration) {
        configuration.increaseIndex();
        String head = configuration.getInputStack().remove(0);
        configuration.getWorkStack().push(new Production(head, List.of(head)));
    }

    private void MOMENTARY_INSUCCESS(Configuration configuration) {
        configuration.setState(BACK);
    }

    private void BACK(Configuration configuration) {
        configuration.decreaseIndex();
        Production lastProduction = configuration.getWorkStack().pop();
        configuration.getInputStack().add(0, lastProduction.getKey());
    }

    private void ANOTHER_TRY(Configuration configuration, MyGrammar grammar) {
        Production lastProduction = configuration.getWorkStack().peek(); // Aj
        List<List<String>> productions = grammar.getProductionsByKey(lastProduction.getKey());
        List<String> nextProductionValue = getNextProduction(lastProduction, productions);

        if (nextProductionValue != null) {
            configuration.setState(NORMAL);
            configuration.getWorkStack().pop();
            configuration.getWorkStack().push(new Production(lastProduction.getKey(), nextProductionValue));

            lastProduction.getValue().forEach(value -> configuration.getInputStack().remove(0) );
            configuration.getInputStack().addAll(0, nextProductionValue);

        } else {
            if (configuration.getIndex() == 0 && Objects.equals(lastProduction.getKey(), grammar.getStartSymbol())) {
                configuration.setState(ERROR);
                configuration.getWorkStack().pop();
                lastProduction.getValue().forEach(value -> configuration.getInputStack().remove(0) );
            } else {
                configuration.getWorkStack().pop();
                lastProduction.getValue().forEach(value -> configuration.getInputStack().remove(0) );
                configuration.getInputStack().add(0, lastProduction.getKey());
            }
        }
    }

    private void SUCCESS(Configuration configuration) {
        configuration.setState(FINAL);
    }

    private List<String> getNextProduction(Production lastProduction, List<List<String>> productions) {

        for (int i = 0; i < productions.size() - 1; i++) {
            if (Objects.equals(productions.get(i), lastProduction.getValue()))
                return productions.get(i + 1);
        }
        return null;
    }
}
