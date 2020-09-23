package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class CompositeFunctionTest {
    private final static double DELTA = 0.00001;

    @Test
    public void testApply() {
        IdentityFunction idFun = new IdentityFunction();
        LnFunction lnFun = new LnFunction();
        CompositeFunction comFun = new CompositeFunction(idFun,idFun);
        assertEquals(comFun.apply(1),1,DELTA);

        CompositeFunction comFun1 = new CompositeFunction(idFun,lnFun);
        assertEquals(comFun1.apply(1),0,DELTA);

    }
}