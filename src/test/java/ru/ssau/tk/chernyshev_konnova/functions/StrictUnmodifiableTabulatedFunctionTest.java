package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import java.util.Iterator;

import static org.testng.Assert.*;

public class StrictUnmodifiableTabulatedFunctionTest {

    private final double[] xValues = new double[]{1, 2, 3, 4, 5};
    private final double[] yValues = new double[]{10, 20, 30, 40, 50};

    private ArrayTabulatedFunction getDefinedThroughArrays() {
        return new ArrayTabulatedFunction(xValues, yValues);
    }

    private StrictTabulatedFunction getStrictArrays() {
        return new StrictTabulatedFunction(getDefinedThroughArrays());
    }

    private LinkedListTabulatedFunction getListOfArray() {
        return new LinkedListTabulatedFunction(yValues, xValues);
    }

    private UnmodifiableTabulatedFunction getUnmodifiableList() {
        return new UnmodifiableTabulatedFunction(getListOfArray());
    }

    @Test
    public void testGetCount() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getStrictArrays());
        assertEquals(testArrayFunction.getCount(), 5);

        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getUnmodifiableList());
        assertEquals(testListFunction.getCount(), 5);
    }

    @Test
    public void testGetX() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getStrictArrays());
        assertEquals(testArrayFunction.getX(0), 1);
        assertEquals(testArrayFunction.getX(1), 2);
        assertEquals(testArrayFunction.getX(2), 3);

        UnmodifiableTabulatedFunction testListFunction = new UnmodifiableTabulatedFunction(getUnmodifiableList());
        assertEquals(testListFunction.getX(0), 10);
        assertEquals(testListFunction.getX(1), 20);
        assertEquals(testListFunction.getX(2), 30);
    }

    @Test
    public void testGetY() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getStrictArrays());
        assertEquals(testArrayFunction.getY(0), 10);
        assertEquals(testArrayFunction.getY(1), 20);
        assertEquals(testArrayFunction.getY(2), 30);

        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getUnmodifiableList());
        assertEquals(testListFunction.getY(0), 1);
        assertEquals(testListFunction.getY(1), 2);
        assertEquals(testListFunction.getY(2), 3);
    }

    @Test
    public void testSetY() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getStrictArrays());
        assertThrows(UnsupportedOperationException.class, () -> testArrayFunction.setY(0, 0));
        assertThrows(UnsupportedOperationException.class, () -> testArrayFunction.setY(1, 0));

        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getUnmodifiableList());
        assertThrows(UnsupportedOperationException.class, () -> testListFunction.setY(0, 0));
        assertThrows(UnsupportedOperationException.class, () -> testListFunction.setY(10, 0));
    }

    @Test
    public void testIndexOfX() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getStrictArrays());
        assertEquals(testArrayFunction.indexOfX(1), 0);
        assertEquals(testArrayFunction.indexOfX(2), 1);
        assertEquals(testArrayFunction.indexOfX(3), 2);

        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getUnmodifiableList());
        assertEquals(testListFunction.indexOfX(10), 0);
        assertEquals(testListFunction.indexOfX(20), 1);
        assertEquals(testListFunction.indexOfX(30), 2);
    }

    @Test
    public void testIndexOfY() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getStrictArrays());
        assertEquals(testArrayFunction.indexOfY(10), 0);
        assertEquals(testArrayFunction.indexOfY(20), 1);
        assertEquals(testArrayFunction.indexOfY(30), 2);

        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getUnmodifiableList());
        assertEquals(testListFunction.indexOfY(1), 0);
        assertEquals(testListFunction.indexOfY(2), 1);
        assertEquals(testListFunction.indexOfY(3), 2);
    }

    @Test
    public void testLeftBound() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getStrictArrays());
        assertEquals(testArrayFunction.leftBound(), 1);

        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getUnmodifiableList());
        assertEquals(testListFunction.leftBound(), 10);
    }

    @Test
    public void testRightBound() {
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getStrictArrays());
        assertEquals(testArrayFunction.rightBound(), 5);

        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getUnmodifiableList());
        assertEquals(testListFunction.rightBound(), 50);
    }

    @Test
    public void testIterator() {
        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getUnmodifiableList());
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
        UnmodifiableTabulatedFunction testArrayFunction = new UnmodifiableTabulatedFunction(getStrictArrays());
        assertEquals(testArrayFunction.apply(1), 10);
        assertEquals(testArrayFunction.apply(2), 20);
        assertEquals(testArrayFunction.apply(3), 30);
        StrictTabulatedFunction testListFunction = new StrictTabulatedFunction(getUnmodifiableList());
        assertEquals(testListFunction.apply(10), 1);
        assertEquals(testListFunction.apply(20), 2);
        assertEquals(testListFunction.apply(30), 3);

        assertThrows(UnsupportedOperationException.class, () -> testArrayFunction.apply(-2));
        assertThrows(UnsupportedOperationException.class, () -> testListFunction.apply(-2));
    }
}