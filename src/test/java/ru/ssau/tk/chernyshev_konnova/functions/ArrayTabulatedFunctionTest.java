package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static ru.ssau.tk.chernyshev_konnova.functions.SomeConstants.*;

public class ArrayTabulatedFunctionTest {
    private final double[] valuesX = new double[]{-27, -8, -1, 0, 1, 8, 27};
    private final double[] valuesY = new double[]{-3, -2, -1, -0, 1, 2, 3};
    private final MathFunction cbrtFunction = new CbrtFunction();

    private ArrayTabulatedFunction getDefinedThroughArrays() {
        return new ArrayTabulatedFunction(valuesX, valuesY);
    }

    private ArrayTabulatedFunction getDefinedThroughMathFunction() {
        return new ArrayTabulatedFunction(cbrtFunction, 0, 27, 109);
    }

    private ArrayTabulatedFunction getUnitArray() {
        return new ArrayTabulatedFunction(cbrtFunction, 8, 8, 1);
    }


    @Test
    public void testFloorIndexOfX() {
        assertEquals(getDefinedThroughArrays().floorIndexOfX(30), 7, DELTA);
        assertEquals(getDefinedThroughArrays().floorIndexOfX(-1), 2, DELTA);
        assertEquals(getDefinedThroughArrays().floorIndexOfX(-40), 0, DELTA);
        assertEquals(getDefinedThroughMathFunction().floorIndexOfX(-1), 0, DELTA);
        assertEquals(getDefinedThroughMathFunction().floorIndexOfX(30), 109, DELTA);
        assertEquals(getUnitArray().floorIndexOfX(0), 0, DELTA);
        assertEquals(getUnitArray().floorIndexOfX(8), 1, DELTA);
        assertEquals(getUnitArray().floorIndexOfX(10000), 1, DELTA);
    }

    @Test
    public void testExtrapolateLeft() {
        assertEquals(getDefinedThroughArrays().extrapolateLeft(-35), -3.42105, DELTA);
        assertEquals(getDefinedThroughMathFunction().extrapolateLeft(-1), -2.51984208, DELTA);
        assertEquals(getUnitArray().extrapolateLeft(5), 5, DELTA);
    }

    @Test
    public void testExtrapolateRight() {
        assertEquals(getDefinedThroughArrays().extrapolateRight(35), 3.42105, DELTA);
        assertEquals(getDefinedThroughMathFunction().extrapolateRight(30), 3.111456, DELTA);
        assertEquals(getUnitArray().extrapolateLeft(5), 5, DELTA);
    }

    @Test
    public void testInterpolate() {
        assertEquals(getDefinedThroughArrays().interpolate(0.5, getDefinedThroughArrays().floorIndexOfX(0.5)), 0.5, DELTA);
        assertEquals(getDefinedThroughMathFunction().interpolate(0.125, getDefinedThroughMathFunction().floorIndexOfX(0.125)), 0.31498, DELTA);
        assertEquals(getUnitArray().interpolate(10, getUnitArray().floorIndexOfX(10)), 10, DELTA);
    }

    @Test
    public void testGetCount() {
        assertEquals(getDefinedThroughArrays().getCount(), 7);
        assertEquals(getDefinedThroughMathFunction().getCount(), 109);
        assertEquals(getUnitArray().getCount(), 1);
    }

    @Test
    public void testGetX() {
        assertEquals(getDefinedThroughArrays().getX(0), -27, DELTA);
        assertEquals(getDefinedThroughArrays().getX(4), 1, DELTA);
        assertEquals(getDefinedThroughArrays().getX(5), 8, DELTA);
        assertEquals(getDefinedThroughMathFunction().getX(0), 0, DELTA);
        assertEquals(getDefinedThroughMathFunction().getX(8), 2, DELTA);
        assertEquals(getDefinedThroughMathFunction().getX(108), 27, DELTA);
        assertEquals(getUnitArray().getX(0), 8, DELTA);
    }

    @Test
    public void testGetY() {
        assertEquals(getDefinedThroughArrays().getY(0), -3, DELTA);
        assertEquals(getDefinedThroughArrays().getY(4), 1, DELTA);
        assertEquals(getDefinedThroughArrays().getY(5), 2, DELTA);
        assertEquals(getDefinedThroughMathFunction().getY(0), 0, DELTA);
        assertEquals(getDefinedThroughMathFunction().getY(8), 1.259921, DELTA);
        assertEquals(getDefinedThroughMathFunction().getY(108), 3, DELTA);
        assertEquals(getUnitArray().getY(0), 2, DELTA);
    }

    @Test
    public void testSetY() {
        ArrayTabulatedFunction testDefinedThroughArrays = getDefinedThroughArrays();
        ArrayTabulatedFunction testDefinedThroughMathFunction = getDefinedThroughMathFunction();
        ArrayTabulatedFunction testUnitArray = getUnitArray();

        testDefinedThroughArrays.setY(5, 100500);
        testDefinedThroughMathFunction.setY(0, 1009);
        testUnitArray.setY(0, 9);
        assertEquals(testDefinedThroughArrays.getY(5), 100500, DELTA);
        assertEquals(testDefinedThroughMathFunction.getY(0), 1009, DELTA);
        assertEquals(testUnitArray.getY(0), 9, DELTA);
    }

    @Test
    public void testIndexOfX() {
        assertEquals(getDefinedThroughArrays().indexOfX(1), 4, DELTA);
        assertEquals(getDefinedThroughArrays().indexOfX(0.5), -1, DELTA);
        assertEquals(getDefinedThroughMathFunction().indexOfX(8), 32, DELTA);
        assertEquals(getDefinedThroughMathFunction().indexOfX(0.1), -1, DELTA);
        assertEquals(getUnitArray().indexOfX(8), 0, DELTA);
        assertEquals(getUnitArray().indexOfX(10), -1, DELTA);
    }

    @Test
    public void testIndexOfY() {
        assertEquals(getDefinedThroughArrays().indexOfY(2), 5, DELTA);
        assertEquals(getDefinedThroughArrays().indexOfY(0.5), -1, DELTA);
        assertEquals(getDefinedThroughMathFunction().indexOfY(1), 4, DELTA);
        assertEquals(getDefinedThroughMathFunction().indexOfY(0.1), -1, DELTA);
        assertEquals(getUnitArray().indexOfY(2), 0, DELTA);
        assertEquals(getUnitArray().indexOfY(10), -1, DELTA);
    }

    @Test
    public void testLeftBound() {
        assertEquals(getDefinedThroughArrays().leftBound(), -27, DELTA);
        assertEquals(getDefinedThroughMathFunction().leftBound(), 0, DELTA);
        assertEquals(getUnitArray().leftBound(), 8, DELTA);
    }

    @Test
    public void testRightBound() {
        assertEquals(getDefinedThroughArrays().rightBound(), 27, DELTA);
        assertEquals(getDefinedThroughMathFunction().rightBound(), 27, DELTA);
        assertEquals(getUnitArray().rightBound(), 8, DELTA);
    }

    @Test
    public void testApply() {
        assertEquals(getDefinedThroughArrays().apply(-35), -3.42105, DELTA);
        assertEquals(getDefinedThroughMathFunction().apply(-1), -2.51984208, DELTA);
        assertEquals(getDefinedThroughArrays().apply(35), 3.42105, DELTA);
        assertEquals(getDefinedThroughMathFunction().apply(30), 3.111456, DELTA);
        assertEquals(getDefinedThroughArrays().apply(0.5), 0.5, DELTA);
        assertEquals(getDefinedThroughMathFunction().apply(0.125), 0.31498, DELTA);
        assertEquals(getUnitArray().apply(10), 10, DELTA);
        assertEquals(getDefinedThroughMathFunction().apply(8), 2, DELTA);
    }

    @Test
    public void testRemove() {
        ArrayTabulatedFunction testDefinedThroughArrays = getDefinedThroughArrays();
        testDefinedThroughArrays.remove(6);
        testDefinedThroughArrays.remove(3);
        testDefinedThroughArrays.remove(0);
       /* our start array: [(-27, -3) (-8, -2) (-1, -1) (0, 0) (1, 1) (8, 2) (27, 3)]
        our start array: [(-8, -2) (-1, -1) (1, 1) (8, 2)] */
        assertEquals(testDefinedThroughArrays.getX(0), -8, DELTA);
        assertEquals(testDefinedThroughArrays.getX(1), -1, DELTA);
        assertEquals(testDefinedThroughArrays.getX(2), 1, DELTA);
        assertEquals(testDefinedThroughArrays.getX(3), 8, DELTA);
    }

    @Test
    public void testInsert() {
        double[] x = new double[]{1, 2, 3};
        double[] y = new double[]{10, 20, 30};
        ArrayTabulatedFunction array = new ArrayTabulatedFunction(x, y);
        array.insert(0, 0);
        assertEquals(array.getY(0), 0);
        array.insert(6, 5);
        assertEquals(array.getY(4), 5);
        array.insert(6, 60);
        assertEquals(array.getY(4), 60);
        array.insert(4, 40);
        assertEquals(array.getY(4), 40);
        array.insert(5, 50);
        assertEquals(array.getY(5), 50);


    }
}
