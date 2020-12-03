package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.functions.simple.ConstantFunction;

import static org.testng.Assert.*;
import static ru.ssau.tk.chernyshev_konnova.functions.SomeConstants.*;

public class ConstantFunctionTest {

    private final ConstantFunction constantFunction = new ConstantFunction(7);

    @Test
    public void testApply() {
        assertEquals(constantFunction.apply(217947), 7, DELTA);
        assertNotEquals(constantFunction.apply(1655), 1655, DELTA);
        assertEquals(constantFunction.apply(165165), 7, DELTA);
    }

    @Test
    public void testGetC() {
        assertEquals(constantFunction.getC(), 7, DELTA);
        assertNotEquals(constantFunction.getC(), 8, DELTA);
        assertEquals(constantFunction.getC(), 7, DELTA);
    }
}