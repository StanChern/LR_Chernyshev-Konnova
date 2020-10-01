package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static ru.ssau.tk.chernyshev_konnova.functions.SomeConstants.*;

public class ZeroFunctionTest {

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