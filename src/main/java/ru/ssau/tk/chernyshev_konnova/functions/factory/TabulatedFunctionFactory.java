package ru.ssau.tk.chernyshev_konnova.functions.factory;

import ru.ssau.tk.chernyshev_konnova.functions.StrictTabulatedFunction;
import ru.ssau.tk.chernyshev_konnova.functions.TabulatedFunction;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues);

    default TabulatedFunction createStrict(double[] xValues, double[] yValues) {
        return new StrictTabulatedFunction(create(xValues, yValues));
    }
}