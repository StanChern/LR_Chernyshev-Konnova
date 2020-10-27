package ru.ssau.tk.chernyshev_konnova.io;

import ru.ssau.tk.chernyshev_konnova.functions.*;
import ru.ssau.tk.chernyshev_konnova.functions.factory.*;

import java.io.*;

public class TabulatedFunctionFileInputStream {
    public static void main(String[] args) {
        File arrayFile = new File("input/binary function.bin");
        try {
            BufferedInputStream inArray = new BufferedInputStream(new FileInputStream(arrayFile));

            ArrayTabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
            TabulatedFunction arrayFunction = FunctionsIO.readTabulatedFunction(inArray, arrayFactory);

            System.out.print(arrayFunction.toString());
        } catch (IOException err) {
            err.printStackTrace();

        }
    }
}
