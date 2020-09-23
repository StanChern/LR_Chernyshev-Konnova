package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ZeroFunctionTest {

    ZeroFunction zeroFun = new ZeroFunction();

    @Test
    public void testZeroApply() {
        assertEquals(zeroFun.apply(11651), 0);
        assertNotEquals(zeroFun.apply(1655), 1655, 0);
    }

    @Test
    public void testZeroGet() {
        assertEquals(zeroFun.getC(), 0);
        assertNotEquals(zeroFun.getC(), 1, 0);
    }
}