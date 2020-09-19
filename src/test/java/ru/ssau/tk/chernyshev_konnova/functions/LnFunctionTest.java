package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LnFunctionTest {
    private final static double DELTA = 0.00001;

    @Test
    public void testApply() {
        LnFunction lnFun = new LnFunction();
        assertEquals(lnFun.apply(1),0,DELTA);
       assertEquals(lnFun.apply(2),0.6931471,DELTA);
    }
}