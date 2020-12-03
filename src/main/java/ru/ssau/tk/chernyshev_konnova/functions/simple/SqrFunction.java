package ru.ssau.tk.chernyshev_konnova.functions.simple;

import ru.ssau.tk.chernyshev_konnova.functions.MathFunction;

public class SqrFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return Math.pow(x, 2);
    }
}
