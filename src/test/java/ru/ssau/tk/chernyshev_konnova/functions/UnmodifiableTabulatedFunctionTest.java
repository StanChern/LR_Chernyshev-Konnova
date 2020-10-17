package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import java.util.Iterator;

import static org.testng.Assert.*;

public class UnmodifiableTabulatedFunctionTest {

    private final double[] xValues = new double[]{1, 2, 3, 4, 5};
    private final double[] yValues = new double[]{10, 20, 30, 40, 50};

    private ArrayTabulatedFunction getDefinedThroughArrays() {
        return new ArrayTabulatedFunction(xValues, yValues);
    }

    private LinkedListTabulatedFunction getDefinedThroughMathFunction() {
        return new LinkedListTabulatedFunction(yValues, xValues);
    }

    @Test
    public void testGetCount() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.getCount(), 5);

        UnmodifiableTabulatedFunction testListFunction = new UnmodifiableTabulatedFunction(getDefinedThroughMathFunction());
        assertEquals(testListFunction.getCount(), 5);
    }

    @Test
    public void testGetX() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.getX(0), 1);
        assertEquals(testArrayFunction.getX(1), 2);
        assertEquals(testArrayFunction.getX(2), 3);

        UnmodifiableTabulatedFunction testListFunction = new UnmodifiableTabulatedFunction(getDefinedThroughMathFunction());
        assertEquals(testListFunction.getX(0), 10);
        assertEquals(testListFunction.getX(1), 20);
        assertEquals(testListFunction.getX(2), 30);
    }

    @Test
    public void testGetY() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.getY(0), 10);
        assertEquals(testArrayFunction.getY(1), 20);
        assertEquals(testArrayFunction.getY(2), 30);

        UnmodifiableTabulatedFunction testListFunction = new UnmodifiableTabulatedFunction(getDefinedThroughMathFunction());
        assertEquals(testListFunction.getY(0), 1);
        assertEquals(testListFunction.getY(1), 2);
        assertEquals(testListFunction.getY(2), 3);
    }

    @Test
    public void testSetY() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getDefinedThroughArrays());
        assertThrows(UnsupportedOperationException.class, () -> testArrayFunction.setY(0, 0));
        assertThrows(UnsupportedOperationException.class, () -> testArrayFunction.setY(1, 0));

        UnmodifiableTabulatedFunction testListFunction = new UnmodifiableTabulatedFunction(getDefinedThroughMathFunction());
        assertThrows(UnsupportedOperationException.class, () -> testListFunction.setY(0, 0));
        assertThrows(UnsupportedOperationException.class, () -> testListFunction.setY(10, 0));
    }

    @Test
    public void testIndexOfX() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.indexOfX(1), 0);
        assertEquals(testArrayFunction.indexOfX(2), 1);
        assertEquals(testArrayFunction.indexOfX(3), 2);

        UnmodifiableTabulatedFunction testListFunction = new UnmodifiableTabulatedFunction(getDefinedThroughMathFunction());
        assertEquals(testListFunction.indexOfX(10), 0);
        assertEquals(testListFunction.indexOfX(20), 1);
        assertEquals(testListFunction.indexOfX(30), 2);
    }

    @Test
    public void testIndexOfY() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.indexOfY(10), 0);
        assertEquals(testArrayFunction.indexOfY(20), 1);
        assertEquals(testArrayFunction.indexOfY(30), 2);

        UnmodifiableTabulatedFunction testListFunction = new UnmodifiableTabulatedFunction(getDefinedThroughMathFunction());
        assertEquals(testListFunction.indexOfY(1), 0);
        assertEquals(testListFunction.indexOfY(2), 1);
        assertEquals(testListFunction.indexOfY(3), 2);
    }

    @Test
    public void testLeftBound() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.leftBound(), 1);

        UnmodifiableTabulatedFunction testListFunction = new UnmodifiableTabulatedFunction(getDefinedThroughMathFunction());
        assertEquals(testListFunction.leftBound(), 10);
    }

    @Test
    public void testRightBound() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.rightBound(), 5);

        UnmodifiableTabulatedFunction testListFunction = new UnmodifiableTabulatedFunction(getDefinedThroughMathFunction());
        assertEquals(testListFunction.rightBound(), 50);
    }

    @Test
    public void testIterator() {
        UnmodifiableTabulatedFunction testListFunction = new UnmodifiableTabulatedFunction(getDefinedThroughMathFunction());
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
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getDefinedThroughArrays());
        assertEquals(testArrayFunction.apply(1), 10);
        assertEquals(testArrayFunction.apply(2), 20);
        assertEquals(testArrayFunction.apply(2.5), 25);

        UnmodifiableTabulatedFunction testListFunction = new UnmodifiableTabulatedFunction(getDefinedThroughMathFunction());
        assertEquals(testListFunction.apply(10), 1);
        assertEquals(testListFunction.apply(20), 2);
        assertEquals(testListFunction.apply(25), 2.5);
    }
}