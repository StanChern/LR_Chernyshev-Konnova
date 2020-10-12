package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import java.util.Iterator;

import static org.testng.Assert.*;
import static ru.ssau.tk.chernyshev_konnova.functions.SomeConstants.*;

public class LinkedListTabulatedFunctionTest {

    private final double[] xValues = new double[]{1, 2, 3, 4, 5};
    private final double[] yValues = new double[]{10, 20, 30, 40, 50};
    private final MathFunction testFunction = new LnFunction();

    private LinkedListTabulatedFunction getListOfArray() {

        return new LinkedListTabulatedFunction(xValues, yValues);
    }

    private LinkedListTabulatedFunction getListOfMathFunction() {
        return new LinkedListTabulatedFunction(testFunction, 5, 10, 20);
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
        // LinkedListTabulatedFunction testList = getListOfArray();
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
        LinkedListTabulatedFunction testListArray = getListOfArray();
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
        assertEquals(getListOfMathFunction().floorIndexOfX(-10), 0, DELTA);
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
        assertEquals(testListArray.interpolate(2.5, 2), 25, DELTA);
        assertEquals(testListMath.interpolate(7.5, 3), 2.044978, DELTA);
    }

    @Test
    public void testInsert() {

        double[] valuesXFirst = new double[]{0, 1};
        double[] valuesYFirst = new double[]{0, 10};
        LinkedListTabulatedFunction testListArray = new LinkedListTabulatedFunction(valuesXFirst, valuesYFirst);


        testListArray.insert(3, 30);
        testListArray.insert(2, 20);

        //our list: [(0, 0) (1, 10) (2, 20) (3, 30)]
        assertEquals(testListArray.getX(1), 1, DELTA);
        assertEquals(testListArray.getY(1), 10, DELTA);

        assertEquals(testListArray.getX(0), 0, DELTA);
        assertEquals(testListArray.getY(0), 0, DELTA);

        assertEquals(testListArray.getX(3), 3, DELTA);
        assertEquals(testListArray.getY(3), 30, DELTA);

        assertEquals(testListArray.getX(2), 2, DELTA);
        assertEquals(testListArray.getY(2), 20, DELTA);


    }

    @Test
    public void testRemove() {
        LinkedListTabulatedFunction testList = getListOfArray();
       /*
        for (int i = 0; i < testList.count; i++) {
            System.out.println(testList.getX(i));
        }
        testList.remove(0);
        System.out.println();

        for (int i = 0; i < testList.count; i++) {
            System.out.println(testList.getX(i));
        }
*/
    }

    @Test
    public void testIteratorWhile() {
        LinkedListTabulatedFunction testArrayList = getListOfArray();
        Iterator<Point> myIterator = testArrayList.iterator();
        int k = 0;
        while (myIterator.hasNext()) {
            Point myPoint = myIterator.next();
            assertEquals(testArrayList.getX(k), myPoint.x, DELTA);
            assertEquals(testArrayList.getY(k++), myPoint.y, DELTA);
        }
        assertEquals(testArrayList.getCount(), k);

        LinkedListTabulatedFunction testFunctionList = getListOfMathFunction();
        Iterator<Point> myIteratorToo = testFunctionList.iterator();
        int s = 0;
        while (myIteratorToo.hasNext()) {
            Point myPoint = myIteratorToo.next();
            assertEquals(myPoint.x, testFunctionList.getX(s), DELTA);
            assertEquals(myPoint.y, testFunctionList.getY(s++), DELTA);
        }
        assertEquals(testFunctionList.getCount(), s);
    }

    @Test
    public void testIteratorForEach() {
        LinkedListTabulatedFunction testArrayList = getListOfArray();
        int k = 0;
        for (Point myPoint : testArrayList) {
            assertEquals(myPoint.x, testArrayList.getX(k), DELTA);
            assertEquals(myPoint.y, testArrayList.getY(k++), DELTA);
        }
        assertEquals(testArrayList.getCount(), k);

        LinkedListTabulatedFunction testFunctionList = getListOfMathFunction();
        int s = 0;
        for (Point myPoint : testFunctionList) {
            assertEquals(myPoint.x, testFunctionList.getX(s), DELTA);
            assertEquals(myPoint.y, testFunctionList.getY(s++), DELTA);
        }
        assertEquals(testFunctionList.getCount(), s);
    }
}
