package ru.ssau.tk.chernyshev_konnova.functions.factory;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.functions.ArrayTabulatedFunction;

import static org.testng.Assert.*;

public class ArrayTabulatedFunctionFactoryTest {
    private final double[] valuesX = new double[]{-27, -8, -1, 0, 1, 8, 27};
    private final double[] valuesY = new double[]{-3, -2, -1, -0, 1, 2, 3};

    @Test
    public void testCreate() {
        var testArrayFunction = new ArrayTabulatedFunctionFactory().create(valuesX, valuesY);
        assertTrue(testArrayFunction instanceof ArrayTabulatedFunction);
    }
}