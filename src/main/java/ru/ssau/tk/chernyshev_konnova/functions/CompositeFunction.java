package ru.ssau.tk.chernyshev_konnova.functions;

public class CompositeFunction implements MathFunction {
    private MathFunction firstFunction;
    private MathFunction secondFunction;

    public CompositeFunction(MathFunction f1, MathFunction f2){
        this.firstFunction = f1;
        this.secondFunction = f2;

    }

    @Override
    public double apply(double x) {

        return 0;
    }
}
