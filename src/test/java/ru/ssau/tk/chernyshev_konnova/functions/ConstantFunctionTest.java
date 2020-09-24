package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConstantFunctionTest {

    private final static double DELTA = 0.00001;

    ConstantFunction constFun = new ConstantFunction(7);

    @Test
    public void testApply() {
        assertEquals(constFun.apply(217947), 7, DELTA);
        assertNotEquals(constFun.apply(1655), 1655, DELTA);
    }

    @Test
    public void testGetC() {
        assertEquals(constFun.getC(), 7, DELTA);
        assertNotEquals(constFun.getC(), 8, DELTA);
    }
}