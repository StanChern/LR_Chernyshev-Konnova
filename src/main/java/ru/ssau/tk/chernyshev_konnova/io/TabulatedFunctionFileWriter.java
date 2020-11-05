package ru.ssau.tk.chernyshev_konnova.io;

import ru.ssau.tk.chernyshev_konnova.functions.*;

import java.io.*;

public class TabulatedFunctionFileWriter {
    public static void main(String[] args) {
        double[] x = {1, 2, 3};
        double[] y = {10, 20, 30};
        TabulatedFunction listFunction = new LinkedListTabulatedFunction(x, y);
        TabulatedFunction arrayFunction = new ArrayTabulatedFunction(x, y);
        try (BufferedWriter outArray = new BufferedWriter(new FileWriter("output/array function.txt"));
             BufferedWriter outList = new BufferedWriter(new FileWriter("output/linked list function.txt"))) {
            FunctionsIO.writeTabulatedFunction(outArray, arrayFunction);
            FunctionsIO.writeTabulatedFunction(outList, listFunction);

        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
