package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.exceptions.InterpolationException;
import ru.ssau.tk.chernyshev_konnova.functions.simple.LnFunction;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;
import static ru.ssau.tk.chernyshev_konnova.functions.SomeConstants.*;

public class LinkedListTabulatedFunctionTest {

    private final double[] xValues = new double[]{1, 2, 3, 4, 5};
    private final double[] yValues = new double[]{10, 20, 30, 40, 50};
    private final MathFunction lnFunction = new LnFunction();

    private LinkedListTabulatedFunction getListOfArray() {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }

    private LinkedListTabulatedFunction getListOfMathFunction() {
        return new LinkedListTabulatedFunction(lnFunction, 5, 10, 20);
    }

    @Test
    public void testLinkedListTabulatedFunction() {
        double[] xValues = {5.8};
        double[] yValues = {0.2};
        assertThrows(IllegalArgumentException.class, () -> new LinkedListTabulatedFunction(xValues, yValues));
        double[] xValues1 = new double[]{};
        assertThrows(IllegalArgumentException.class, () -> new LinkedListTabulatedFunction(xValues1, yValues));
        assertThrows(IllegalArgumentException.class, () -> new LinkedListTabulatedFunction(lnFunction, 10, 2, 10));
        assertThrows(IllegalArgumentException.class, () -> new LinkedListTabulatedFunction(lnFunction, -5, 5, 1));
        assertThrows(IllegalArgumentException.class, () -> new LinkedListTabulatedFunction(lnFunction, 100, 200, -5));
        assertThrows(IllegalArgumentException.class, () -> new LinkedListTabulatedFunction(lnFunction, 2452, 5, 100000));
    }

    @Test
    public void testApply() {
        assertEquals(getListOfArray().apply(3), 30, DELTA);
        assertEquals(getListOfMathFunction().apply(5), 1.609438, DELTA);

        assertEquals(getListOfArray().apply(7), 70, DELTA);
        assertEquals(getListOfMathFunction().apply(11), 2.403923987, DELTA);

        assertEquals(getListOfArray().apply(0.5), 5, DELTA);
        assertEquals(getListOfMathFunction().apply(7.5), 2.01474910, DELTA);
    }

    @Test
    public void testGetNode() {
        assertEquals(getListOfArray().getX(0), 1, DELTA);
        assertEquals(getListOfArray().getX(1), 2, DELTA);
        assertEquals(getListOfArray().getX(2), 3, DELTA);
        assertEquals(getListOfArray().getX(3), 4, DELTA);
        assertEquals(getListOfArray().getX(4), 5, DELTA);

    }

    @Test
    public void testAddNode() {
        LinkedListTabulatedFunction testList = getListOfArray();
        testList.addNode(6, 60);
        assertEquals(testList.rightBound(), 6, DELTA);
    }

    @Test
    public void testGetCount() {
        assertEquals(getListOfArray().getCount(), 5, DELTA);
        assertEquals(getListOfMathFunction().getCount(), 20, DELTA);
    }

    @Test
    public void testLeftBound() {
        assertEquals(getListOfArray().leftBound(), 1, DELTA);
        assertEquals(getListOfMathFunction().leftBound(), 5, DELTA);
    }

    @Test
    public void testRightBound() {
        assertEquals(getListOfArray().rightBound(), 5, DELTA);
        assertEquals(getListOfMathFunction().rightBound(), 10, DELTA);
    }

    @Test
    public void testGetX() {
        assertEquals(getListOfArray().getX(0), 1, DELTA);
        assertEquals(getListOfMathFunction().getX(0), 5, DELTA);
        assertThrows(IndexOutOfBoundsException.class, () -> getListOfArray().getX(-4545));
        assertThrows(IndexOutOfBoundsException.class, () -> getListOfArray().getX(-250));
        assertThrows(IndexOutOfBoundsException.class, () -> getListOfArray().getX(10000));
    }

    @Test
    public void testGetY() {
        assertEquals(getListOfArray().getY(0), 10, DELTA);
        assertEquals(getListOfMathFunction().getY(0), 1.609438, DELTA);
        assertThrows(IndexOutOfBoundsException.class, () -> getListOfArray().getY(-4545));
        assertThrows(IndexOutOfBoundsException.class, () -> getListOfArray().getY(-250));
        assertThrows(IndexOutOfBoundsException.class, () -> getListOfArray().getY(10000));
    }

    @Test
    public void testSetY() {
        TabulatedFunction testListArray = getListOfArray();
        testListArray.setY(4, 60);
        assertEquals(testListArray.getY(4), 60, DELTA);
        assertThrows(IndexOutOfBoundsException.class, () -> getListOfArray().setY(-250, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> getListOfArray().setY(-45, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> getListOfArray().setY(250, 0));
    }

    @Test
    public void testIndexOfX() {
        assertEquals(getListOfArray().indexOfX(5), 4, DELTA);
        assertEquals(getListOfMathFunction().indexOfX(5), 0, DELTA);
        assertEquals(getListOfArray().indexOfX(100), -1, DELTA);

    }

    @Test
    public void testIndexOfY() {
        assertEquals(getListOfArray().indexOfY(10), 0, DELTA);
        assertEquals(getListOfMathFunction().indexOfY(5), -1, DELTA);
    }

    @Test
    public void testFloorIndexOfX() {
        assertEquals(getListOfArray().floorIndexOfX(3.7), 2, DELTA);
        assertThrows(IllegalArgumentException.class, () -> getListOfArray().floorIndexOfX(-10));
        assertEquals(getListOfMathFunction().floorIndexOfX(100), 20, DELTA);
    }

    @Test
    public void testExtrapolateLeft() {
        assertEquals(getListOfArray().extrapolateLeft(1.5), 15, DELTA);
        assertEquals(getListOfMathFunction().extrapolateLeft(4), 1.4145233565, DELTA);
    }

    @Test
    public void testExtrapolateRight() {
        LinkedListTabulatedFunction testListArray = getListOfArray();
        LinkedListTabulatedFunction testListMath = getListOfMathFunction();
        assertEquals(testListArray.extrapolateRight(8), 80, DELTA);
        assertEquals(testListMath.extrapolateRight(11), 2.403923987, DELTA);
    }

    @Test
    public void testInterpolate() {
        LinkedListTabulatedFunction testListArray = getListOfArray();
        LinkedListTabulatedFunction testListMath = getListOfMathFunction();
        assertEquals(testListArray.interpolate(2.5, 1), 25, DELTA);
        assertEquals(testListMath.interpolate(7.5, 9), 2.014749, DELTA);
        assertThrows(InterpolationException.class, () -> testListArray.interpolate(2.5, 2));
        assertThrows(InterpolationException.class, () -> testListMath.interpolate(7.5, 3));
    }

    @Test
    public void testInsert() {

        double[] valuesXFirst = new double[]{0, 1};
        double[] valuesYFirst = new double[]{0, 10};
        LinkedListTabulatedFunction testListArray = new LinkedListTabulatedFunction(valuesXFirst, valuesYFirst);

        testListArray.insert(3, 30);
        testListArray.insert(2, 20);
        testListArray.insert(-5, -50);
        testListArray.insert(-2, -20);

        //our list: [(-5, -50) (-2, -20) (0, 0) (1, 10) (2, 20) (3, 30)]
        assertEquals(testListArray.getX(0), -5, DELTA);
        assertEquals(testListArray.getY(0), -50, DELTA);

        assertEquals(testListArray.getX(1), -2, DELTA);
        assertEquals(testListArray.getY(1), -20, DELTA);

        assertEquals(testListArray.getX(2), 0, DELTA);
        assertEquals(testListArray.getY(2), 0, DELTA);

        assertEquals(testListArray.getX(3), 1, DELTA);
        assertEquals(testListArray.getY(3), 10, DELTA);

        assertEquals(testListArray.getX(4), 2, DELTA);
        assertEquals(testListArray.getY(4), 20, DELTA);

        assertEquals(testListArray.getX(5), 3, DELTA);
        assertEquals(testListArray.getY(5), 30, DELTA);

        assertEquals(testListArray.getCount(), 6);
    }

    @Test
    public void testRemove() {
        LinkedListTabulatedFunction testList = getListOfArray();
        testList.remove(0);
        testList.remove(3);
        testList.remove(1);
       /* our start list: [(1, 10) (2, 20) (3, 30) (4, 40) (5, 50)]
        our result list: [(2, 20) (4, 40)] */
        assertEquals(testList.getX(0), 2, DELTA);
        assertEquals(testList.getX(1), 4, DELTA);
        assertEquals(testList.getY(0), 20, DELTA);
        assertEquals(testList.getY(1), 40, DELTA);

        assertEquals(testList.getCount(), 2);
    }

    @Test
    public void testIteratorWhile() {
        TabulatedFunction testArrayList = getListOfArray();
        Iterator<Point> myIterator = testArrayList.iterator();
        int k = 0;
        while (myIterator.hasNext()) {
            Point myPoint = myIterator.next();
            assertEquals(testArrayList.getX(k), myPoint.x, DELTA);
            assertEquals(testArrayList.getY(k++), myPoint.y, DELTA);
        }
        assertEquals(testArrayList.getCount(), k);

        TabulatedFunction testFunctionList = getListOfMathFunction();
        Iterator<Point> myIteratorToo = testFunctionList.iterator();
        int s = 0;
        while (myIteratorToo.hasNext()) {
            Point myPoint = myIteratorToo.next();
            assertEquals(myPoint.x, testFunctionList.getX(s), DELTA);
            assertEquals(myPoint.y, testFunctionList.getY(s++), DELTA);
        }
        assertEquals(testFunctionList.getCount(), s);
        assertThrows(NoSuchElementException.class, myIterator::next);
    }

    @Test
    public void testIteratorForEach() {
        TabulatedFunction testArrayList = getListOfArray();
        int k = 0;
        for (Point myPoint : testArrayList) {
            assertEquals(myPoint.x, testArrayList.getX(k), DELTA);
            assertEquals(myPoint.y, testArrayList.getY(k++), DELTA);
        }
        assertEquals(testArrayList.getCount(), k);

        TabulatedFunction testFunctionList = getListOfMathFunction();
        int s = 0;
        for (Point myPoint : testFunctionList) {
            assertEquals(myPoint.x, testFunctionList.getX(s), DELTA);
            assertEquals(myPoint.y, testFunctionList.getY(s++), DELTA);
        }
        assertEquals(testFunctionList.getCount(), s);
    }
}
