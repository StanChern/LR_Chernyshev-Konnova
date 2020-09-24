package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ZeroFunctionTest {

    private final static double DELTA = 0.00001;
    ZeroFunction zeroFun = new ZeroFunction();

    @Test
    public void testZeroApply() {
        assertEquals(zeroFun.apply(11651), 0, DELTA);
        assertNotEquals(zeroFun.apply(1655), 1655, DELTA);
    }

    @Test
    public void testZeroGet() {
        assertEquals(zeroFun.getC(), 0, DELTA);
        assertNotEquals(zeroFun.getC(), 1, DELTA);
    }
}