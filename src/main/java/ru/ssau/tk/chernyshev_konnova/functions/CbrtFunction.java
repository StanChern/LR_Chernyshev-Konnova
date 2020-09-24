package ru.ssau.tk.chernyshev_konnova.functions;

public class CbrtFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return Math.cbrt(x);
    }
}
