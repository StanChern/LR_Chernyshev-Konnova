package ru.ssau.tk.chernyshev_konnova.functions;

public interface MathFunction {
    double apply (double x);

    default CompositeFunction andThen(MathFunction afterFunction) {
        return new CompositeFunction(this, afterFunction);
    }
}
