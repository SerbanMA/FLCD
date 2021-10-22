package main.java.main;

import main.java.MyScanner;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        String filename = "p1.txt";
        File file = new File("src/resources/files/codes/" + filename);

        MyScanner myScanner = new MyScanner();

        myScanner.scan(file);
        myScanner.print();

    }
}
