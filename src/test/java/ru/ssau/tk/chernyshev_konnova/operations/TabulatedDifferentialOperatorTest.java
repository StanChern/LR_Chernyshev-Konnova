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
        assertTrue(testList instanceof LinkedListTabulatedFunction);
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

        TabulatedFunction testArray = new ArrayTabulatedFunction(new double[]{1, 2, 3, 4, 5, 6}, new double[]{10, 40, 90, 160, 250, 360});
        TabulatedDifferentialOperator differentialArrayOperator = new TabulatedDifferentialOperator(new ArrayTabulatedFunctionFactory());
        testArray = differentialArrayOperator.derive(testArray);
        assertTrue(testArray instanceof ArrayTabulatedFunction);
        assertEquals(testArray.getX(0), 1);
        assertEquals(testArray.getX(1), 2);
        assertEquals(testArray.getX(2), 3);
        assertEquals(testArray.getX(3), 4);
        assertEquals(testArray.getX(4), 5);
        assertEquals(testArray.getX(5), 6);

        assertEquals(testArray.getY(0), 30);
        assertEquals(testArray.getY(1), 50);
        assertEquals(testArray.getY(2), 70);
        assertEquals(testArray.getY(3), 90);
        assertEquals(testArray.getY(4), 110);
        assertEquals(testArray.getY(5), 110);
    }

    @Test
    public void testDeriveSynchronously() {
        TabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(new double[]{1, 2, 3, 4}, new double[]{10, 20, 30, 40});
        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction diffFunctionList = differentialOperator.deriveSynchronously(linkedListTabulatedFunction);

        TabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(new double[]{1, 2, 3, 4}, new double[]{1, 4, 9, 16});
        TabulatedDifferentialOperator differentialOperator1 = new TabulatedDifferentialOperator(new ArrayTabulatedFunctionFactory());
        TabulatedFunction diffFunctionArray = differentialOperator1.deriveSynchronously(arrayTabulatedFunction);

        assertTrue(diffFunctionList instanceof LinkedListTabulatedFunction);
        assertEquals(diffFunctionList.getX(0), 1);
        assertEquals(diffFunctionList.getX(1), 2);
        assertEquals(diffFunctionList.getX(2), 3);
        assertEquals(diffFunctionList.getX(3), 4);

        assertEquals(diffFunctionList.getY(0), 10);
        assertEquals(diffFunctionList.getY(1), 10);
        assertEquals(diffFunctionList.getY(2), 10);
        assertEquals(diffFunctionList.getY(3), 10);

        assertTrue(diffFunctionArray instanceof ArrayTabulatedFunction);
        assertEquals(diffFunctionArray.getX(0), 1);
        assertEquals(diffFunctionArray.getX(1), 2);
        assertEquals(diffFunctionArray.getX(2), 3);
        assertEquals(diffFunctionArray.getX(3), 4);

        assertEquals(diffFunctionArray.getY(0), 3);
        assertEquals(diffFunctionArray.getY(1), 5);
        assertEquals(diffFunctionArray.getY(2), 7);
        assertEquals(diffFunctionArray.getY(3), 7);
    }
}