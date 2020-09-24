package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SqrFunctionTest {

    private final static double DELTA = 0.00001;

    @Test
    public void testApply() {
        MathFunction sqrFunction = new SqrFunction();
        assertEquals(sqrFunction.apply(3), 9, DELTA);
        assertEquals(sqrFunction.apply(0), 0, DELTA);
        assertEquals(sqrFunction.apply(-5), 25, DELTA);
    }
}