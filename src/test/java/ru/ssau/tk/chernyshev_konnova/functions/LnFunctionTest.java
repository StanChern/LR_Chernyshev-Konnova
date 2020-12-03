package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.functions.simple.LnFunction;

import static org.testng.Assert.*;
import static ru.ssau.tk.chernyshev_konnova.functions.SomeConstants.*;

public class LnFunctionTest {

    @Test
    public void testApply() {
        MathFunction lnFunction = new LnFunction();
        assertEquals(lnFunction.apply(1), 0, DELTA);
        assertEquals(lnFunction.apply(2), 0.6931471, DELTA);
        assertEquals(lnFunction.apply(Math.exp(3)), 3, DELTA);
    }
}