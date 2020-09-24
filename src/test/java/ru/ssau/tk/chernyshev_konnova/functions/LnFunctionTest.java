package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LnFunctionTest {

    private final static double DELTA = 0.00001;

    @Test
    public void testApply() {
        MathFunction lnFunction = new LnFunction();
        assertEquals(lnFunction.apply(1), 0, DELTA);
        assertEquals(lnFunction.apply(2), 0.6931471, DELTA);
        assertEquals(lnFunction.apply(Math.exp(3)), 3, DELTA);
    }
}