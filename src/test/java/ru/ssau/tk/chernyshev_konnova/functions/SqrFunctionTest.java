package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SqrFunctionTest {

    private final static double DELTA = 0.00001;

    @Test
    public void testApply() {
        SqrFunction sqrFun = new SqrFunction();
        assertEquals(sqrFun.apply(9), 3, DELTA);
        assertEquals(sqrFun.apply(0), 0, DELTA);
    }
}