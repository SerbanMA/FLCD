package main.java.domain;

public class Pair {
    private final String key;
    private final Integer value;

    public Pair() {
        this.key = "";
        this.value = -1;
    }

    public Pair(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + key + "," + value + ")";
    }
}
