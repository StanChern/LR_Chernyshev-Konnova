package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnitFunctionTest {

    private final static double DELTA = 0.00001;
    private ConstantFunction unitFunction = new UnitFunction();

    @Test
    public void testUnitApply() {
        assertEquals(unitFunction.apply(11651), 1, DELTA);
        assertNotEquals(unitFunction.apply(1655), 1655, DELTA);
        assertEquals(unitFunction.apply(61651), 1, DELTA);
    }

    @Test
    public void testUnitGet() {
        assertEquals(unitFunction.getC(), 1, DELTA);
        assertNotEquals(unitFunction.getC(), 165, DELTA);
        assertEquals(unitFunction.getC(), 1, DELTA);
    }
}