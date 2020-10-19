package ru.ssau.tk.chernyshev_konnova.operations;

import ru.ssau.tk.chernyshev_konnova.functions.MathFunction;

public interface DifferentialOperator<T extends MathFunction> {
    T derive(T function);

}
