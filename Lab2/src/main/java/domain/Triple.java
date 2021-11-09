package main.java.domain;

public class Triple {
    private final String start;
    private final String value;
    private final String finish;

    public Triple(String start, String value, String finish) {
        this.start = start;
        this.value = value;
        this.finish = finish;

    }

    public String getStart() {
        return start;
    }

    public String getValue() {
        return value;
    }

    public String getFinish() {
        return finish;
    }

    @Override
    public String toString() {
        return "(" +
                start + " -<" +
                value + ">- " +
                finish + ")";

    }
}
