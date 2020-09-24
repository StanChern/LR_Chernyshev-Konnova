package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnitFunctionTest {
    private final static double DELTA = 0.00001;
    UnitFunction unitFun = new UnitFunction();

    @Test
    public void testUnitApply() {
        assertEquals(unitFun.apply(11651), 1, DELTA);
        assertNotEquals(unitFun.apply(1655), 1655, DELTA);
    }

    @Test
    public void testUnitGet() {
        assertEquals(unitFun.getC(), 1, DELTA);
        assertNotEquals(unitFun.getC(), 165, DELTA);
    }
}