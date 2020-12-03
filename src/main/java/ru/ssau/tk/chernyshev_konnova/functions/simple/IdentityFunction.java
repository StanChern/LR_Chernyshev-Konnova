package ru.ssau.tk.chernyshev_konnova.functions.simple;

import ru.ssau.tk.chernyshev_konnova.functions.MathFunction;

public class IdentityFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return x;
    }
}
