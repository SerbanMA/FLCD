package main.java.helper;

public class RegexHelper {

    public RegexHelper() {
    }

    public boolean isIdentifier(String value) {
        return value.matches("^_?[a-zA-Z][a-zA-Z0-9]*$");
    }

    public boolean isConstant(String value) {
        return isBoolean(value) ||
                isInteger(value) ||
                isInteger(value) ||
                isCharacter(value) ||
                isString(value);
    }

    public boolean isBoolean(String value) {
        return value.matches("^[01]$");
    }

    public boolean isInteger(String value) {
        return value.matches("^([+-]?[1-9][0-9]*)|0$");
    }

    public boolean isCharacter(String value) {
        return value.matches("^'[a-zA-Z0-9 ]'$");
    }

    public boolean isString(String value) {
        return value.matches("^\"[a-zA-Z0-9 ]*\"$");
    }
}