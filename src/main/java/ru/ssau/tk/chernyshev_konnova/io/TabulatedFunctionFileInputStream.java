package ru.ssau.tk.chernyshev_konnova.io;

import ru.ssau.tk.chernyshev_konnova.functions.*;
import ru.ssau.tk.chernyshev_konnova.functions.factory.*;
import ru.ssau.tk.chernyshev_konnova.operations.TabulatedDifferentialOperator;

import java.io.*;

public class TabulatedFunctionFileInputStream {
    public static void main(String[] args) {
        File arrayFile = new File("input/binary function.bin");
        LinkedListTabulatedFunctionFactory listFactory = new LinkedListTabulatedFunctionFactory();
        ArrayTabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
        try (BufferedInputStream inArray = new BufferedInputStream(new FileInputStream(arrayFile))) {
            TabulatedFunction arrayFunction = FunctionsIO.readTabulatedFunction(inArray, arrayFactory);

            System.out.println(arrayFunction.toString());
        } catch (IOException err) {
            err.printStackTrace();

        }
        try {
            BufferedReader inList = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите размер и значения функции");
            TabulatedFunction listFunction = FunctionsIO.readTabulatedFunction(inList, listFactory);

            TabulatedDifferentialOperator diffList = new TabulatedDifferentialOperator(listFactory);
            System.out.println(diffList.derive(listFunction).toString());

        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
