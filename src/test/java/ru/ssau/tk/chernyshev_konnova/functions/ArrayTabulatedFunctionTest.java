package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayTabulatedFunctionTest {
    private final static double DELTA = 0.00001;
    double[] valuesX = new double[]{-27, -8, -1, 0, 1, 8, 27};
    double[] valuesY = new double[]{-3, -2, -1, -0, 1, 2, 3};
    MathFunction cbrtFunction = new CbrtFunction();
    ArrayTabulatedFunction definedThroughArrays = new ArrayTabulatedFunction(valuesX, valuesY);
    ArrayTabulatedFunction definedThroughMathFunction = new ArrayTabulatedFunction(cbrtFunction, 0, 27, 109);
    ArrayTabulatedFunction unitArray = new ArrayTabulatedFunction(cbrtFunction, 8, 8, 1);

    @Test
    public void testFloorIndexOfX() {
        assertEquals(definedThroughArrays.floorIndexOfX(30), 7, DELTA);
        assertEquals(definedThroughArrays.floorIndexOfX(-1), 2, DELTA);
        assertEquals(definedThroughArrays.floorIndexOfX(-40), 0, DELTA);
        assertEquals(definedThroughMathFunction.floorIndexOfX(-1), 0, DELTA);
        assertEquals(definedThroughMathFunction.floorIndexOfX(30), 109, DELTA);
        assertEquals(unitArray.floorIndexOfX(0), 0, DELTA);
        assertEquals(unitArray.floorIndexOfX(8), 1, DELTA);
        assertEquals(unitArray.floorIndexOfX(10000), 1, DELTA);
    }

    @Test
    public void testExtrapolateLeft() {
        assertEquals(definedThroughArrays.extrapolateLeft(-35), -3.42105, DELTA);
        assertEquals(definedThroughMathFunction.extrapolateLeft(-1), -2.51984208, DELTA);
        assertEquals(unitArray.extrapolateLeft(5), 5, DELTA);
    }

    @Test
    public void testExtrapolateRight() {
        assertEquals(definedThroughArrays.extrapolateRight(35), 3.42105, DELTA);
        assertEquals(definedThroughMathFunction.extrapolateRight(30), 3.111456, DELTA);
        assertEquals(unitArray.extrapolateLeft(5), 5, DELTA);
    }

    @Test
    public void testInterpolate() {
        assertEquals(definedThroughArrays.interpolate(0.5, definedThroughArrays.floorIndexOfX(0.5)), 0.5, DELTA);
        assertEquals(definedThroughMathFunction.interpolate(0.125, definedThroughMathFunction.floorIndexOfX(0.125)), 0.31498, DELTA);
        assertEquals(unitArray.interpolate(10, unitArray.floorIndexOfX(10)), 10, DELTA);
    }

    @Test
    public void testGetCount() {
        assertEquals(definedThroughArrays.getCount(), 7);
        assertEquals(definedThroughMathFunction.getCount(), 109);
        assertEquals(unitArray.getCount(), 1);
    }

    @Test
    public void testGetX() {
        assertEquals(definedThroughArrays.getX(0), -27, DELTA);
        assertEquals(definedThroughArrays.getX(4), 1, DELTA);
        assertEquals(definedThroughArrays.getX(5), 8, DELTA);
        assertEquals(definedThroughMathFunction.getX(0), 0, DELTA);
        assertEquals(definedThroughMathFunction.getX(8), 2, DELTA);
        assertEquals(definedThroughMathFunction.getX(108), 27, DELTA);
        assertEquals(unitArray.getX(0), 8, DELTA);
    }

    @Test
    public void testGetY() {
        assertEquals(definedThroughArrays.getY(0), -3, DELTA);
        assertEquals(definedThroughArrays.getY(4), 1, DELTA);
        assertEquals(definedThroughArrays.getY(5), 2, DELTA);
        assertEquals(definedThroughMathFunction.getY(0), 0, DELTA);
        assertEquals(definedThroughMathFunction.getY(8), 1.259921, DELTA);
        assertEquals(definedThroughMathFunction.getY(108), 3, DELTA);
        assertEquals(unitArray.getY(0), 2, DELTA);
    }

    @Test
    public void testSetY() {
        definedThroughArrays.setY(5, 100500);
        definedThroughMathFunction.setY(0, 1009);
        unitArray.setY(0, 9);
        assertEquals(definedThroughArrays.getY(5), 100500, DELTA);
        assertEquals(definedThroughMathFunction.getY(0), 1009, DELTA);
        assertEquals(unitArray.getY(0), 9, DELTA);
    }

    @Test
    public void testIndexOfX() {
        assertEquals(definedThroughArrays.indexOfX(1), 4, DELTA);
        assertEquals(definedThroughArrays.indexOfX(0.5), -1, DELTA);
        assertEquals(definedThroughMathFunction.indexOfX(8), 32, DELTA);
        assertEquals(definedThroughMathFunction.indexOfX(0.1), -1, DELTA);
        assertEquals(unitArray.indexOfX(8), 0, DELTA);
        assertEquals(unitArray.indexOfX(10), -1, DELTA);
    }

    @Test
    public void testIndexOfY() {
        assertEquals(definedThroughArrays.indexOfY(2), 5, DELTA);
        assertEquals(definedThroughArrays.indexOfY(0.5), -1, DELTA);
        assertEquals(definedThroughMathFunction.indexOfY(1), 4, DELTA);
        assertEquals(definedThroughMathFunction.indexOfY(0.1), -1, DELTA);
        assertEquals(unitArray.indexOfY(2), 0, DELTA);
        assertEquals(unitArray.indexOfY(10), -1, DELTA);
    }

    @Test
    public void testLeftBound() {
        assertEquals(definedThroughArrays.leftBound(), -27, DELTA);
        assertEquals(definedThroughMathFunction.leftBound(), 0, DELTA);
        assertEquals(unitArray.leftBound(), 8, DELTA);
    }

    @Test
    public void testRightBound() {
        assertEquals(definedThroughArrays.rightBound(), 27, DELTA);
        assertEquals(definedThroughMathFunction.rightBound(), 27, DELTA);
        assertEquals(unitArray.rightBound(), 8, DELTA);
    }
}