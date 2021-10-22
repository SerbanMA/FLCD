package main.java.helper;

public class TypeHelper extends DataHelper{

    public TypeHelper() {}

    public boolean isOperator(String value) {
        return getOperators().contains(value);
    }

    public boolean isSeparator(String value) {
        return getSeparators().contains(value);
    }

    public boolean isReservedWord(String value) {
        return getReservedWords().contains(value);
    }
}
