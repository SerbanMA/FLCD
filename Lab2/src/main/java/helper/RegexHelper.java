package main.java.helper;

import main.java.service.MyFA;

public class RegexHelper {

    public RegexHelper() {
    }

    public boolean isIdentifierRegex(String value) {
        return value.matches("^_?[a-zA-Z][a-zA-Z0-9]*$");
    }

    public boolean isIdentifier(String value) {
        MyFA myFA = new MyFA("identifier_fa.in");
        return myFA.isAccepted(value);
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

    public boolean isIntegerRegex(String value) {
        return value.matches("^([+-]?[1-9][0-9]*)|0$");
    }

    public boolean isInteger(String value) {
        MyFA myFA = new MyFA("integer_fa.in");
        return myFA.isAccepted(value);
    }

    public boolean isCharacter(String value) {
        return value.matches("^'[a-zA-Z0-9 ]'$");
    }

    public boolean isString(String value) {
        return value.matches("^\"[a-zA-Z0-9 ]*\"$");
    }
}