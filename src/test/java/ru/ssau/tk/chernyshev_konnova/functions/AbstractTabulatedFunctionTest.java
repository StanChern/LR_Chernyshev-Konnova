package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AbstractTabulatedFunctionTest {
    private final static double DELTA = 0.00001;
    MockTabulatedFunction myMockObject = new MockTabulatedFunction();

    @Test
    public void testInterpolate() {
        assertEquals(myMockObject.interpolate(2, 1, 3, 5, 7), 6, DELTA);
    }

    @Test
    public void testApply() {
        assertEquals(myMockObject.apply(7), 11, DELTA);
        assertEquals(myMockObject.apply(-7), -3, DELTA);
        assertEquals(myMockObject.apply(2), 6, DELTA);
        assertEquals(myMockObject.apply(1), 5, DELTA);
        assertEquals(myMockObject.apply(3), 7, DELTA);
    }
}