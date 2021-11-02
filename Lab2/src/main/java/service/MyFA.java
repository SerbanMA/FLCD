package main.java.service;

import main.java.domain.Triple;
import main.java.helper.constants.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MyFA {
    private Set<String> states;
    private Set<String> alphabet;
    private final Set<Triple> transitions = new HashSet<>();
    private String initialState;
    private Set<String> finalStates;

    public MyFA(String fileName) {
        readData(fileName);
    }

    public Set<String> getStates() {
        return states;
    }

    public Set<String> getAlphabet() {
        return alphabet;
    }

    public Set<Triple> getTransitions() {
        return transitions;
    }

    public String getInitialState() {
        return initialState;
    }

    public Set<String> getFinalStates() {
        return finalStates;
    }

    public boolean isAccepted(String value) {
        String currentStare = initialState;

        List<String> characters = Pattern.compile("")
                .splitAsStream(value)
                .collect(Collectors.toCollection(ArrayList::new));

        for (String character : characters) {

            boolean inTransitions = false;
            for (Triple transition : transitions) {
                if (transition.getOne().equals(currentStare)
                        && transition.getTwo().equals(character)) {
                    currentStare = transition.getThree();
                    inTransitions = true;
                }
            }

            if (!inTransitions) {
                return false;
            }
        }

        return finalStates.contains(currentStare);
    }

    private void readData(String fileName) {

        File file = new File(Constant.input + fileName);
        try {
            Scanner myReader = new Scanner(file);

            states = Pattern.compile(",")
                    .splitAsStream(myReader.nextLine())
                    .collect(Collectors.toCollection(HashSet::new));

            alphabet = Pattern.compile(",")
                    .splitAsStream(myReader.nextLine())
                    .collect(Collectors.toCollection(HashSet::new));

            String[] transition = myReader.nextLine().split("~");
            while (transition.length == 3) {
                transitions.add(new Triple(transition[0], transition[1], transition[2]));
                transition = myReader.nextLine().split("~");
            }

            initialState = transition[0];

            finalStates = Pattern.compile(",")
                    .splitAsStream(myReader.nextLine())
                    .collect(Collectors.toCollection(HashSet::new));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
