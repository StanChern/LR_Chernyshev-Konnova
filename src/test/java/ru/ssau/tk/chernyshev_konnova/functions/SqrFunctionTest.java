package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SqrFunctionTest {

    @Test
    public void testApply() {
        SqrFunction sqrFun = new SqrFunction();
        assertEquals(sqrFun.apply(9), 3);
        assertEquals(sqrFun.apply(0), 0);
    }
}