package main.java.main;

import main.java.helper.iostream.ReaderHelper;
import main.java.service.MyFA;
import main.java.service.MyGrammar;
import main.java.service.MyParser;
import main.java.service.MyScanner;
import main.java.helper.constants.Constant;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        {
            {
                String filename = "p1.txt";
                File file = new File(Constant.codes + filename);
                MyScanner myScanner = new MyScanner();
                myScanner.scan(file);
            }
            {
                String filename = "p1err.txt";
                File file = new File(Constant.codes + filename);
                MyScanner myScanner = new MyScanner();
                myScanner.scan(file);
            }
            {
                String filename = "p2.txt";
                File file = new File(Constant.codes + filename);
                MyScanner myScanner = new MyScanner();
                myScanner.scan(file);
            }
            {
                String filename = "p3.txt";
                File file = new File(Constant.codes + filename);
                MyScanner myScanner = new MyScanner();
                myScanner.scan(file);
            }
        }

        MyFA myFA = new MyFA("fa.in");
        MyGrammar myGrammar = new MyGrammar("g2.in");

        int option = 1;

        while (option != 0)
        {
            Main.printMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1 -> System.out.println(myFA.getStates());
                case 2 -> System.out.println(myFA.getAlphabet());
                case 3 -> System.out.println(myFA.getTransitions());
                case 4 -> System.out.println(myFA.getInitialState());
                case 5 -> System.out.println(myFA.getFinalStates());
                case 6 -> {
                    System.out.print(">> ");
                    String value = scanner.next();
                    System.out.println(myFA.isAccepted(value));
                }
                case 7 -> System.out.println(myGrammar);
                case 8 -> {
                    System.out.print(">> ");
                    String value = scanner.next();
                    System.out.println(myGrammar.getProductionsByKey(value));
                }
                case 9 -> System.out.println(myGrammar.isContextFree());
                default -> System.out.println("No such option");
            }
        }

        MyGrammar grammar = new MyGrammar("g2.in");
        MyParser parser = new MyParser();

        String sequence = ReaderHelper.getSequenceFromPIF("p1_pif.txt");

        System.out.println(sequence);

        parser.recursiveDescendant(grammar, sequence);
    }

    public static void printMenu() {
        System.out.println("Choose:");
        System.out.println("1. The set of states");
        System.out.println("2. The alphabet");
        System.out.println("3. The transitions");
        System.out.println("4. The initial state");
        System.out.println("5. The set of final states");
        System.out.println("6. isAccepted");
        System.out.println("7. The grammar");
        System.out.println("8. The Productions of a nonTerminal");
        System.out.println("9. isContextFree");
        System.out.println("0. Close");
        System.out.print(">> ");
    }
}
