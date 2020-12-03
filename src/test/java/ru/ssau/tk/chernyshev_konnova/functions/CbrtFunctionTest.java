package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.functions.simple.CbrtFunction;

import static org.testng.Assert.*;
import static ru.ssau.tk.chernyshev_konnova.functions.SomeConstants.*;

public class CbrtFunctionTest {

    @Test
    public void testApply() {
        MathFunction cbrtFunction = new CbrtFunction();
        assertEquals(cbrtFunction.apply(27), 3, DELTA);
        assertEquals(cbrtFunction.apply(0), 0, DELTA);
        assertEquals(cbrtFunction.apply(-27), -3, DELTA);
    }
}