package ru.ssau.tk.chernyshev_konnova.functions.factory;

import ru.ssau.tk.chernyshev_konnova.functions.ArrayTabulatedFunction;
import ru.ssau.tk.chernyshev_konnova.functions.TabulatedFunction;

public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory {

    @Override
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new ArrayTabulatedFunction(xValues, yValues);
    }
}
