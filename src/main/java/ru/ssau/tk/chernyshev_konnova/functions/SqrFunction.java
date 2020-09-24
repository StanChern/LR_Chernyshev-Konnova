package ru.ssau.tk.chernyshev_konnova.functions;

public class SqrFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return Math.pow(x, 2);
    }
}
