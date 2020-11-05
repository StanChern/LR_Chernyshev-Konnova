package ru.ssau.tk.chernyshev_konnova.io;

import ru.ssau.tk.chernyshev_konnova.functions.*;

import java.io.*;

public class TabulatedFunctionFileOutputStream {
    public static void main(String[] args) {
        File arrayFile = new File("output/array function.bin");
        File listFile = new File("output/linked list function.bin");
        double[] x = {1, 2, 3};
        double[] y = {10, 20, 30};
        TabulatedFunction listFunction = new LinkedListTabulatedFunction(x, y);
        TabulatedFunction arrayFunction = new ArrayTabulatedFunction(x, y);
        try (BufferedOutputStream outArray = new BufferedOutputStream(new FileOutputStream(arrayFile));
             BufferedOutputStream outList = new BufferedOutputStream(new FileOutputStream(listFile))) {
            FunctionsIO.writeTabulatedFunction(outArray, arrayFunction);
            FunctionsIO.writeTabulatedFunction(outList, listFunction);

        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
