package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdentityFunctionTest {

    private final static double DELTA = 0.00001;

    @Test
    public void testApply() {
        MathFunction identityFunction = new IdentityFunction();
        assertEquals(identityFunction.apply(5.632), 5.632, DELTA);
        assertEquals(identityFunction.apply(0), 0, DELTA);
        assertEquals(identityFunction.apply(0.00002567), 0.00002567, DELTA);
    }
}