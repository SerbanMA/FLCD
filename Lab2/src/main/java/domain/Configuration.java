package main.java.domain;

import java.util.Stack;

public class Configuration {
    private String state;
    private Integer index;
    private final Stack<Rule> workStack;
    private final Stack<String> inputStack;

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public void increaseIndex() {
        index += 1;
    }

    public void decreaseIndex() {
        index -= 1;
    }

    public Integer getIndex() {
        return index;
    }

    public Stack<Rule> getWorkStack() {
        return workStack;
    }

    public Stack<String> getInputStack() {
        return inputStack;
    }

    public Configuration(String startSymbol) {
        state = "q";
        index = 0;
        workStack = new Stack<>();
        inputStack = new Stack<>();
        inputStack.push(startSymbol);
    }
}
