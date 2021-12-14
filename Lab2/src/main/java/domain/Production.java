package main.java.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Production {
    private final String key;
    private List<String> value;

    public Production() {
        this.key = "";
        this.value = new ArrayList<>();
    }

    public Production(String key, List<String> value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public List<String> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(key: " + key + ", value: " + value + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Production that = (Production) o;
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
