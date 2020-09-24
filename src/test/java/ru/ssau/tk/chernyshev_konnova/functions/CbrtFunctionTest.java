package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CbrtFunctionTest {

    private final static double DELTA = 0.00001;

    @Test
    public void testApply() {
        MathFunction cbrtFunction = new CbrtFunction();
        assertEquals(cbrtFunction.apply(27), 3, DELTA);
        assertEquals(cbrtFunction.apply(0), 0, DELTA);
        assertEquals(cbrtFunction.apply(-27), -3, DELTA);
    }
}