package ru.ssau.tk.chernyshev_konnova.functions.factory;

import ru.ssau.tk.chernyshev_konnova.functions.StrictTabulatedFunction;
import ru.ssau.tk.chernyshev_konnova.functions.TabulatedFunction;
import ru.ssau.tk.chernyshev_konnova.functions.UnmodifiableTabulatedFunction;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues);

    default TabulatedFunction createStrict(double[] xValues, double[] yValues) {
        return new StrictTabulatedFunction(create(xValues, yValues));
    }

    default TabulatedFunction createUnmodifiable(double[] xValues, double[] yValues) {
        return new UnmodifiableTabulatedFunction(create(xValues, yValues));
    }

    default TabulatedFunction createStrictUnmodifiable(double[] xValues, double[] yValues) {
        return new StrictTabulatedFunction(new UnmodifiableTabulatedFunction(create(xValues, yValues)));
    }
}