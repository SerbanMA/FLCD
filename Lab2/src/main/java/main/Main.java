package main.java.main;

import main.java.MyScanner;
import main.java.helper.constants.Constant;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        String filename = "p1.txt";
        File file = new File(Constant.codes + filename);

        MyScanner myScanner = new MyScanner();

        myScanner.scan(file);
    }
}
