package main.java.domain;

public class Rule {
    private final String key;
    private final String value;

    public Rule() {
        this.key = "";
        this.value = "";
    }

    public Rule(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(key: " + key + ", value: " + value + ")";
    }
}
