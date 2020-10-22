package ru.ssau.tk.chernyshev_konnova.functions.factory;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.functions.LinkedListTabulatedFunction;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionFactoryTest {
    private final double[] valuesX = new double[]{-27, -8, -1, 0, 1, 8, 27};
    private final double[] valuesY = new double[]{-3, -2, -1, -0, 1, 2, 3};

    @Test
    public void testCreate() {
        var testListFunction = new LinkedListTabulatedFunctionFactory().create(valuesX, valuesY);
        assertTrue(testListFunction instanceof LinkedListTabulatedFunction);
    }
}