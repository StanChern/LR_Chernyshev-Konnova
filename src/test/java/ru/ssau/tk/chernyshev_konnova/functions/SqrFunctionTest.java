package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static ru.ssau.tk.chernyshev_konnova.functions.SomeConstants.*;

public class SqrFunctionTest {

    @Test
    public void testApply() {
        MathFunction sqrFunction = new SqrFunction();
        assertEquals(sqrFunction.apply(3), 9, DELTA);
        assertEquals(sqrFunction.apply(0), 0, DELTA);
        assertEquals(sqrFunction.apply(-5), 25, DELTA);
    }
}