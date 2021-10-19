package main.java.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class RegexHelper {

    public RegexHelper() {}

    public boolean isBoolean (String value) {
        return value.matches("^[01]$");
    }

    public boolean isInteger (String value) {
        return value.matches("^[+-]?[1-9][0-9]*$");
    }

    public boolean isCharacter (String value) {
        return value.matches("^'[a-zA-Z0-9 ]'$");
    }
    
    public boolean isString (String value) {
        return value.matches("^\"[a-zA-Z0-9 ]*\"$");
    }

    public static void main (String[] args) {

        RegexHelper regexHelper = new RegexHelper();

        System.out.println(regexHelper.isBoolean("1"));
        System.out.println(regexHelper.isBoolean("0"));
        System.out.println(regexHelper.isBoolean("01"));
        System.out.println(regexHelper.isBoolean("true"));
        System.out.println(regexHelper.isBoolean("false"));
        System.out.println("-----");
        System.out.println(regexHelper.isInteger("123"));
        System.out.println(regexHelper.isInteger(" 123"));
        System.out.println(regexHelper.isInteger("123 "));
        System.out.println(regexHelper.isInteger("12a3"));
        System.out.println("-----");
        System.out.println(regexHelper.isCharacter("a"));
        System.out.println(regexHelper.isCharacter("'a"));
        System.out.println(regexHelper.isCharacter("'a'"));
        System.out.println(regexHelper.isCharacter("a'"));
        System.out.println(regexHelper.isCharacter("'ab'"));
        System.out.println("-----");

    }
}
