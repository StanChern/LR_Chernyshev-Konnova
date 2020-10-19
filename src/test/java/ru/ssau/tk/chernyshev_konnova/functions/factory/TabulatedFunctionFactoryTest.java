package ru.ssau.tk.chernyshev_konnova.functions.factory;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.functions.*;

import static org.testng.Assert.*;

public class TabulatedFunctionFactoryTest {

    @Test
    public void testCreateStrict() {
        double[] x = {1, 2, 3, 4};
        double[] y = {10, 20, 30, 40};

        TabulatedFunctionFactory listFactory = new LinkedListTabulatedFunctionFactory();
        TabulatedFunction strictListFunction = listFactory.createStrict(x, y);

        assertTrue((strictListFunction instanceof StrictTabulatedFunction));
    }
}