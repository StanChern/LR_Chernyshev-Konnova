package ru.ssau.tk.chernyshev_konnova.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.functions.ArrayTabulatedFunction;
import ru.ssau.tk.chernyshev_konnova.functions.*;
import ru.ssau.tk.chernyshev_konnova.functions.factory.*;

import static org.testng.Assert.*;

public class TabulatedDifferentialOperatorTest {

    @Test
    public void testDerive() {
        TabulatedFunction testList = new LinkedListTabulatedFunction(new double[]{1, 2, 3, 4, 5, 6}, new double[]{1, 4, 9, 16, 25, 36});
        TabulatedDifferentialOperator differentialListOperator = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
        testList = differentialListOperator.derive(testList);

        assertEquals(testList.getX(0), 1);
        assertEquals(testList.getX(1), 2);
        assertEquals(testList.getX(2), 3);
        assertEquals(testList.getX(3), 4);
        assertEquals(testList.getX(4), 5);
        assertEquals(testList.getX(5), 6);

        assertEquals(testList.getY(0), 3);
        assertEquals(testList.getY(1), 5);
        assertEquals(testList.getY(2), 7);
        assertEquals(testList.getY(3), 9);
        assertEquals(testList.getY(4), 11);
        assertEquals(testList.getY(5), 11);

    }
}