package main.java.helper;

public class RegexHelper {

    public RegexHelper() {}

    public boolean isBoolean(String value) {
        return value.matches("^[01]$");
    }

    public boolean isInteger(String value) {
        return value.matches("^[+-]?[1-9][0-9]*$");
    }

    public boolean isCharacter(String value) {
        return value.matches("^'[a-zA-Z0-9 ]'$");
    }
    
    public boolean isString(String value) {
        return value.matches("^\"[a-zA-Z0-9 ]*\"$");
    }

    public boolean isIdentifier(String value) {
        return value.matches("^_?[a-zA-Z][a-zA-Z0-9]*$");
    }
}
