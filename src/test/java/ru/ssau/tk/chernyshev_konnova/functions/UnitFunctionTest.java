package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnitFunctionTest {
    UnitFunction unitFun = new UnitFunction();

    @Test
    public void testUnitApply() {
        assertEquals(unitFun.apply(11651), 1);
        assertNotEquals(unitFun.apply(1655), 1655, 0);
    }

    @Test
    public void testUnitGet() {
        assertEquals(unitFun.getC(), 1);
        assertNotEquals(unitFun.getC(), 165, 0);
    }
}