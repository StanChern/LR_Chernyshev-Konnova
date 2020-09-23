package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CbrtFunctionTest {

    @Test
    public void testApply() {
        CbrtFunction cbrtFun = new CbrtFunction();
        assertEquals(cbrtFun.apply(27), 3);
        assertEquals(cbrtFun.apply(0), 0);
    }
}