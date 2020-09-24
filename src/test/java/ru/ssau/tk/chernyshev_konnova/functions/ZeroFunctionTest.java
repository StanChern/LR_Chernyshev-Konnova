package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ZeroFunctionTest {

    private final static double DELTA = 0.00001;
    private ConstantFunction zeroFunction = new ZeroFunction();

    @Test
    public void testZeroApply() {
        assertEquals(zeroFunction.apply(11651), 0, DELTA);
        assertNotEquals(zeroFunction.apply(1655), 1655, DELTA);
        assertEquals(zeroFunction.apply(612165), 0, DELTA);
    }

    @Test
    public void testZeroGet() {
        assertEquals(zeroFunction.getC(), 0, DELTA);
        assertNotEquals(zeroFunction.getC(), 1, DELTA);
        assertEquals(zeroFunction.getC(), 0, DELTA);
    }
}