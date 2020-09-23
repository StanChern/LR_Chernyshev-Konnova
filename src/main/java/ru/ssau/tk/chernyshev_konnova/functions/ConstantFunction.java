package ru.ssau.tk.chernyshev_konnova.functions;

public class ConstantFunction implements MathFunction{

    private final double c;

    public ConstantFunction(double c) {
        this.c=c;
    }

    @Override
    public double apply(double x) {
        return c;
    }

    public double getC() {
        return c;
    }
}
