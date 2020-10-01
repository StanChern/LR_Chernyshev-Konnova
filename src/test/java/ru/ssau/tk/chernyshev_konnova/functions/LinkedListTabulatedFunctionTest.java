package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionTest {

    private final double[] xValues = new double[]{1, 2, 3, 4, 5};
    private final double[] yValues = new double[]{10, 20, 30, 40, 50};
    private final MathFunction testFunction = new LnFunction();
    private final double DELTA = 0.00001;

    LinkedListTabulatedFunction listOfArray = new LinkedListTabulatedFunction(xValues, yValues);
    LinkedListTabulatedFunction listOfMathFunction = new LinkedListTabulatedFunction(testFunction, 5, 10, 20);

    @Test
    public void testAddNode() {
        listOfArray.addNode(6, 60);
        assertEquals(listOfArray.rightBound(), 6, DELTA);
    }

    @Test
    public void testGetCount() {
        assertEquals(listOfArray.getCount(), 5, DELTA);
        assertEquals(listOfMathFunction.getCount(), 20, DELTA);
    }

    @Test
    public void testLeftBound() {
        assertEquals(listOfArray.leftBound(), 1, DELTA);
        assertEquals(listOfMathFunction.leftBound(), 5, DELTA);
    }

    @Test
    public void testRightBound() {
        assertEquals(listOfArray.rightBound(), 5, DELTA);
        assertEquals(listOfMathFunction.rightBound(), 10, DELTA);
    }

    @Test
    public void testGetX() {
        assertEquals(listOfArray.getX(0), 1, DELTA);
        assertEquals(listOfMathFunction.getX(0), 5, DELTA);
    }

    @Test
    public void testGetY() {
        assertEquals(listOfArray.getY(0), 10, DELTA);
        assertEquals(listOfMathFunction.getY(0), 1.609438, DELTA);
    }

    @Test
    public void testSetY() {
        listOfArray.setY(4, 60);
        assertEquals(listOfArray.getY(4), 60, DELTA);
    }

    @Test
    public void testIndexOfX() {
        assertEquals(listOfArray.indexOfX(5), 4);
        assertEquals(listOfMathFunction.indexOfX(5), 0);
        assertEquals(listOfArray.indexOfX(100), -1);

    }

    @Test
    public void testIndexOfY() {
        assertEquals(listOfArray.indexOfY(10), 0);
        assertEquals(listOfMathFunction.indexOfY(5), -1);
    }

    @Test
    public void testFloorIndexOfX() {
        assertEquals(listOfArray.floorIndexOfX(3.7), 2);
        assertEquals(listOfMathFunction.floorIndexOfX(-10), 0);
        assertEquals(listOfMathFunction.floorIndexOfX(100), 20);
    }

    @Test
    public void testExtrapolateLeft() {
        assertEquals(listOfArray.extrapolateLeft(1.5), 15);
    }

    @Test
    public void testExtrapolateRight() {
        assertEquals(listOfArray.extrapolateRight(8), 80, DELTA);
    }

    @Test
    public void testInterpolate() {
        assertEquals(listOfArray.interpolate(2.5, 2), 25);
        assertEquals(listOfMathFunction.interpolate(7.5, 3), 2.044978, DELTA);
    }
}

