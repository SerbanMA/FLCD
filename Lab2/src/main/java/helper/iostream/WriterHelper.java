package main.java.helper.iostream;

import main.java.SymbolTable;
import main.java.domain.Pair;
import main.java.helper.constants.Constant;

import java.io.*;
import java.util.ArrayList;

public class WriterHelper {

    public static void writeST(SymbolTable identifiersTable, SymbolTable constantsTable) {
        try {
            FileWriter fileWriter = new FileWriter(Constant.outputST);

            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write("Identifier Table\n- as Binary Search Tree -\n");
            writer.write(identifiersTable.toString());
            writer.write("\n\n");
            writer.write("Constants Table\n- as Binary Search Tree -\n");
            writer.write(constantsTable.toString());

            writer.close();

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void writePIF(ArrayList<Pair> pifList) {
        try {
            FileWriter fileWriter = new FileWriter(Constant.outputPIF);

            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write("PIF List\n- as List -\n");
            for (Pair pair : pifList) {
                writer.write(pair.toString());
                writer.write("\n");
            }

            writer.close();

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
