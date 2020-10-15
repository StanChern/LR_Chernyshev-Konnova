package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import ru.ssau.tk.chernyshev_konnova.exceptions.*;

import static org.testng.Assert.*;
import static ru.ssau.tk.chernyshev_konnova.functions.SomeConstants.*;

public class AbstractTabulatedFunctionTest {
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

    @Test
    public void testCheckLengthIsTheSame() {
        assertThrows(DifferentLengthOfArraysException.class, () -> {
            double[] valuesX = new double[]{-3, 5};
            double[] valuesY = new double[]{9};
            AbstractTabulatedFunction.checkLengthIsTheSame(valuesX, valuesY);
        });
    }

    @Test
    public void testCheckSorted() {
        assertThrows(ArrayIsNotSortedException.class, () -> {
            double[] valuesX = new double[]{-3, 5, 7, 9, 0};
            AbstractTabulatedFunction.checkSorted(valuesX);
        });
    }
}