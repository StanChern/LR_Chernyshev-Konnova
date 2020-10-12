package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import java.util.Iterator;

import static org.testng.Assert.*;

public class StrictTabulatedFunctionTest {

    private final double[] xValues = new double[]{1, 2, 3, 4, 5};
    private final double[] yValues = new double[]{10, 20, 30, 40, 50};

    private ArrayTabulatedFunction getDefinedThroughArrays() {
        return new ArrayTabulatedFunction(xValues, yValues);
    }

    private LinkedListTabulatedFunction getListOfArray() {
        return new LinkedListTabulatedFunction(yValues, xValues);
    }

    @Test
    public void testGetCount() {
        StrictTabulatedFunction testArrayFunction = new StrictTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.getCount(), 5);

        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getListOfArray());
        assertEquals(testListFunction.getCount(), 5);
    }

    @Test
    public void testGetX() {
        StrictTabulatedFunction testArrayFunction = new StrictTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.getX(0), 1);
        assertEquals(testArrayFunction.getX(1), 2);
        assertEquals(testArrayFunction.getX(2), 3);

        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getListOfArray());
        assertEquals(testListFunction.getX(0), 10);
        assertEquals(testListFunction.getX(1), 20);
        assertEquals(testListFunction.getX(2), 30);
    }

    @Test
    public void testGetY() {
        StrictTabulatedFunction testArrayFunction = new StrictTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.getY(0), 10);
        assertEquals(testArrayFunction.getY(1), 20);
        assertEquals(testArrayFunction.getY(2), 30);

        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getListOfArray());
        assertEquals(testListFunction.getY(0), 1);
        assertEquals(testListFunction.getY(1), 2);
        assertEquals(testListFunction.getY(2), 3);
    }

    @Test
    public void testSetY() {
        StrictTabulatedFunction testArrayFunction = new StrictTabulatedFunction(getDefinedThroughArrays());
        testArrayFunction.setY(0, 0);
        testArrayFunction.setY(1, 0);
        testArrayFunction.setY(2, 0);
        assertEquals(testArrayFunction.getY(0), 0);
        assertEquals(testArrayFunction.getY(1), 0);
        assertEquals(testArrayFunction.getY(2), 0);
        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getListOfArray());
        testListFunction.setY(0, 0);
        testListFunction.setY(1, 0);
        testListFunction.setY(2, 0);
        assertEquals(testListFunction.getY(0), 0);
        assertEquals(testListFunction.getY(1), 0);
        assertEquals(testListFunction.getY(2), 0);
    }

    @Test
    public void testIndexOfX() {
        StrictTabulatedFunction testArrayFunction = new StrictTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.indexOfX(1), 0);
        assertEquals(testArrayFunction.indexOfX(2), 1);
        assertEquals(testArrayFunction.indexOfX(3), 2);
        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getListOfArray());
        assertEquals(testListFunction.indexOfX(10), 0);
        assertEquals(testListFunction.indexOfX(20), 1);
        assertEquals(testListFunction.indexOfX(30), 2);
    }

    @Test
    public void testIndexOfY() {
        StrictTabulatedFunction testArrayFunction = new StrictTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.indexOfY(10), 0);
        assertEquals(testArrayFunction.indexOfY(20), 1);
        assertEquals(testArrayFunction.indexOfY(30), 2);
        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getListOfArray());
        assertEquals(testListFunction.indexOfY(1), 0);
        assertEquals(testListFunction.indexOfY(2), 1);
        assertEquals(testListFunction.indexOfY(3), 2);
    }

    @Test
    public void testLeftBound() {
        StrictTabulatedFunction testArrayFunction = new StrictTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.leftBound(), 1);
        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getListOfArray());
        assertEquals(testListFunction.leftBound(), 10);
    }

    @Test
    public void testRightBound() {
        StrictTabulatedFunction testArrayFunction = new StrictTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.rightBound(), 5);
        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getListOfArray());
        assertEquals(testListFunction.rightBound(), 50);
    }

    @Test
    public void testIterator() {
        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getListOfArray());
        Iterator<Point> myIterator = testListFunction.iterator();
        int k = 0;
        for (Point myPoint : testListFunction) {
            myPoint = myIterator.next();
            assertEquals(testListFunction.getX(k), myPoint.x);
            assertEquals(testListFunction.getY(k++), myPoint.y);
        }

    }

    @Test
    public void testApply() {
        StrictTabulatedFunction testArrayFunction = new StrictTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.apply(1), 10);
        assertEquals(testArrayFunction.apply(2), 20);
        assertEquals(testArrayFunction.apply(3), 30);
        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getListOfArray());
        assertEquals(testListFunction.apply(10), 1);
        assertEquals(testListFunction.apply(20), 2);
        assertEquals(testListFunction.apply(30), 3);

        assertThrows(UnsupportedOperationException.class, () -> testArrayFunction.apply(-2));
        assertThrows(UnsupportedOperationException.class, () -> testListFunction.apply(-2));
    }
}