package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConstantFunctionTest {

    ConstantFunction constFun = new ConstantFunction(7);

    @Test
    public void testApply() {
        assertEquals(constFun.apply(217947), 7);
        assertNotEquals(constFun.apply(1655), 1655, 0);
    }

    @Test
    public void testGetC() {
        assertEquals(constFun.getC(), 7);
        assertNotEquals(constFun.getC(), 8, 0);
    }
}