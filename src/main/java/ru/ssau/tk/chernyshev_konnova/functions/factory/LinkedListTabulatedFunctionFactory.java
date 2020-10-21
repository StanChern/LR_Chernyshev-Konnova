package ru.ssau.tk.chernyshev_konnova.functions.factory;

import ru.ssau.tk.chernyshev_konnova.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.chernyshev_konnova.functions.TabulatedFunction;

public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory {

    @Override
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }
}
