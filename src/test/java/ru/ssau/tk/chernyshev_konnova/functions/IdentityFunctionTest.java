package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdentityFunctionTest {

    private final static double DELTA = 0.00001;

    @Test
    public void testApply() {
        IdentityFunction idFun = new IdentityFunction();
        assertEquals(idFun.apply(5.632),5.632,DELTA);
        assertEquals(idFun.apply(0),0,DELTA);
        assertEquals(idFun.apply(0.00002567),0.00002567,DELTA);
    }
}