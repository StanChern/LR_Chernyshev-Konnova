package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.functions.simple.IdentityFunction;

import static org.testng.Assert.*;
import static ru.ssau.tk.chernyshev_konnova.functions.SomeConstants.*;

public class IdentityFunctionTest {

    @Test
    public void testApply() {
        MathFunction identityFunction = new IdentityFunction();
        assertEquals(identityFunction.apply(5.632), 5.632, DELTA);
        assertEquals(identityFunction.apply(0), 0, DELTA);
        assertEquals(identityFunction.apply(0.00002567), 0.00002567, DELTA);
    }
}