package ru.ssau.tk.chernyshev_konnova.functions.simple;

import ru.ssau.tk.chernyshev_konnova.functions.MathFunction;

public class LnFunction implements MathFunction {

    public double apply(double x) {
        return Math.log(x);
    }
}
