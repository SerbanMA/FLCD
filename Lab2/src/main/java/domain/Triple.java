package main.java.domain;

public class Triple {
    private final String one;
    private final String two;
    private final String three;

    public Triple(String one, String two, String three) {
        this.one = one;
        this.two = two;
        this.three = three;

    }

    public String getOne() {
        return one;
    }

    public String getTwo() {
        return two;
    }

    public String getThree() {
        return three;
    }

    @Override
    public String toString() {
        return "(" +
                one + " -<" +
                two + ">- " +
                three + ")";

    }
}
