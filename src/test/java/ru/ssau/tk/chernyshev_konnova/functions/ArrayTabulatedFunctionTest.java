package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.exceptions.InterpolationException;
import ru.ssau.tk.chernyshev_konnova.functions.simple.CbrtFunction;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    @Test
    public void testArrayTabulatedFunction() {
        double[] xValues = {5.8};
        double[] yValues = {0.2};
        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(xValues, yValues));
        double[] xValues1 = new double[]{};
        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(xValues1, yValues));
        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(cbrtFunction, 10, 2, 10));
        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(cbrtFunction, -5, 5, 1));
        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(cbrtFunction, 100, 200, -5));
        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(cbrtFunction, 2452, 5, 100000));
    }

    @Test
    public void testFloorIndexOfX() {
        assertEquals(getDefinedThroughArrays().floorIndexOfX(30), 7, DELTA);
        assertEquals(getDefinedThroughArrays().floorIndexOfX(-1), 2, DELTA);
        assertEquals(getDefinedThroughMathFunction().floorIndexOfX(30), 109, DELTA);
        assertThrows(IllegalArgumentException.class, () -> getDefinedThroughArrays().floorIndexOfX(-100));
        assertThrows(IllegalArgumentException.class, () -> getDefinedThroughArrays().floorIndexOfX(-250));
        assertThrows(IllegalArgumentException.class, () -> getDefinedThroughArrays().floorIndexOfX(-500));
    }

    @Test
    public void testExtrapolateLeft() {
        assertEquals(getDefinedThroughArrays().extrapolateLeft(-35), -3.42105, DELTA);
        assertEquals(getDefinedThroughMathFunction().extrapolateLeft(-1), -2.51984208, DELTA);
    }

    @Test
    public void testExtrapolateRight() {
        assertEquals(getDefinedThroughArrays().extrapolateRight(35), 3.42105, DELTA);
        assertEquals(getDefinedThroughMathFunction().extrapolateRight(30), 3.111456, DELTA);
    }

    @Test
    public void testInterpolate() {
        assertEquals(getDefinedThroughArrays().interpolate(0.5, getDefinedThroughArrays().floorIndexOfX(0.5)), 0.5, DELTA);
        assertEquals(getDefinedThroughMathFunction().interpolate(0.125, getDefinedThroughMathFunction().floorIndexOfX(0.125)), 0.31498, DELTA);
        assertThrows(InterpolationException.class, () -> getDefinedThroughArrays().interpolate(0.5, 2));
        assertThrows(InterpolationException.class, () -> getDefinedThroughMathFunction().interpolate(7.5, 3));
    }

    @Test
    public void testGetCount() {
        assertEquals(getDefinedThroughArrays().getCount(), 7, DELTA);
        assertEquals(getDefinedThroughMathFunction().getCount(), 109, DELTA);
    }

    @Test
    public void testGetX() {
        assertEquals(getDefinedThroughArrays().getX(0), -27, DELTA);
        assertEquals(getDefinedThroughArrays().getX(4), 1, DELTA);
        assertEquals(getDefinedThroughArrays().getX(5), 8, DELTA);
        assertEquals(getDefinedThroughMathFunction().getX(0), 0, DELTA);
        assertEquals(getDefinedThroughMathFunction().getX(8), 2, DELTA);
        assertEquals(getDefinedThroughMathFunction().getX(108), 27, DELTA);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> getDefinedThroughArrays().getX(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> getDefinedThroughArrays().getX(100000));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> getDefinedThroughArrays().getX(56516));
    }

    @Test
    public void testGetY() {
        assertEquals(getDefinedThroughArrays().getY(0), -3, DELTA);
        assertEquals(getDefinedThroughArrays().getY(4), 1, DELTA);
        assertEquals(getDefinedThroughArrays().getY(5), 2, DELTA);
        assertEquals(getDefinedThroughMathFunction().getY(0), 0, DELTA);
        assertEquals(getDefinedThroughMathFunction().getY(8), 1.259921, DELTA);
        assertEquals(getDefinedThroughMathFunction().getY(108), 3, DELTA);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> getDefinedThroughArrays().getX(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> getDefinedThroughArrays().getX(100000));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> getDefinedThroughArrays().getX(56516));
    }

    @Test
    public void testSetY() {
        TabulatedFunction testDefinedThroughArrays = getDefinedThroughArrays();
        TabulatedFunction testDefinedThroughMathFunction = getDefinedThroughMathFunction();

        testDefinedThroughArrays.setY(5, 100500);
        testDefinedThroughMathFunction.setY(0, 1009);
        assertEquals(testDefinedThroughArrays.getY(5), 100500, DELTA);
        assertEquals(testDefinedThroughMathFunction.getY(0), 1009, DELTA);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> getDefinedThroughArrays().getX(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> getDefinedThroughArrays().getX(100000));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> getDefinedThroughArrays().getX(56516));
    }

    @Test
    public void testIndexOfX() {
        assertEquals(getDefinedThroughArrays().indexOfX(1), 4, DELTA);
        assertEquals(getDefinedThroughArrays().indexOfX(0.5), -1, DELTA);
        assertEquals(getDefinedThroughMathFunction().indexOfX(8), 32, DELTA);
        assertEquals(getDefinedThroughMathFunction().indexOfX(0.1), -1, DELTA);
    }

    @Test
    public void testIndexOfY() {
        assertEquals(getDefinedThroughArrays().indexOfY(2), 5, DELTA);
        assertEquals(getDefinedThroughArrays().indexOfY(0.5), -1, DELTA);
        assertEquals(getDefinedThroughMathFunction().indexOfY(1), 4, DELTA);
        assertEquals(getDefinedThroughMathFunction().indexOfY(0.1), -1, DELTA);
    }

    @Test
    public void testLeftBound() {
        assertEquals(getDefinedThroughArrays().leftBound(), -27, DELTA);
        assertEquals(getDefinedThroughMathFunction().leftBound(), 0, DELTA);
    }

    @Test
    public void testRightBound() {
        assertEquals(getDefinedThroughArrays().rightBound(), 27, DELTA);
        assertEquals(getDefinedThroughMathFunction().rightBound(), 27, DELTA);
    }

    @Test
    public void testApply() {
        assertEquals(getDefinedThroughArrays().apply(-35), -3.42105, DELTA);
        assertEquals(getDefinedThroughMathFunction().apply(-1), -2.51984208, DELTA);
        assertEquals(getDefinedThroughArrays().apply(35), 3.42105, DELTA);
        assertEquals(getDefinedThroughMathFunction().apply(30), 3.111456, DELTA);
        assertEquals(getDefinedThroughArrays().apply(0.5), 0.5, DELTA);
        assertEquals(getDefinedThroughMathFunction().apply(0.125), 0.31498, DELTA);
        assertEquals(getDefinedThroughMathFunction().apply(8), 2, DELTA);
    }

    @Test
    public void testRemove() {
        ArrayTabulatedFunction testDefinedThroughArrays = getDefinedThroughArrays();
        testDefinedThroughArrays.remove(6);
        testDefinedThroughArrays.remove(3);
        testDefinedThroughArrays.remove(0);
       /* our start array: [(-27, -3) (-8, -2) (-1, -1) (0, 0) (1, 1) (8, 2) (27, 3)]
        our result array: [(-8, -2) (-1, -1) (1, 1) (8, 2)] */
        assertEquals(testDefinedThroughArrays.getX(0), -8, DELTA);
        assertEquals(testDefinedThroughArrays.getX(1), -1, DELTA);
        assertEquals(testDefinedThroughArrays.getX(2), 1, DELTA);
        assertEquals(testDefinedThroughArrays.getX(3), 8, DELTA);
        assertEquals(testDefinedThroughArrays.getY(0), -2, DELTA);
        assertEquals(testDefinedThroughArrays.getY(1), -1, DELTA);
        assertEquals(testDefinedThroughArrays.getY(2), 1, DELTA);
        assertEquals(testDefinedThroughArrays.getY(3), 2, DELTA);

        assertEquals(testDefinedThroughArrays.getCount(), 4);
    }

    @Test
    public void testInsert() {
        double[] x = new double[]{1, 2, 3};
        double[] y = new double[]{10, 20, 30};
        // our start array: [(1, 10) (2, 20) (3, 30)]

        ArrayTabulatedFunction testArray = new ArrayTabulatedFunction(x, y);

        testArray.insert(0, 0);
        // our array: [(0,0) (1, 10) (2, 20) (3, 30)]
        assertEquals(testArray.getY(0), 0);

        testArray.insert(6, 5);
        // our array: [(0,0) (1, 10) (2, 20) (3, 30) (6, 5)]
        assertEquals(testArray.getY(4), 5);

        testArray.insert(6, 60);
        // our array: [(0,0) (1, 10) (2, 20) (3, 30) (6, 60)]
        assertEquals(testArray.getY(4), 60);

        testArray.insert(4, 40);
        // our array: [(0,0) (1, 10) (2, 20) (3, 30) (4, 40) (6, 60)]
        assertEquals(testArray.getY(4), 40);

        testArray.insert(5, 50);
        // our result array: [(0,0) (1, 10) (2, 20) (3, 30) (4, 40) (5, 50) (6, 60)]
        assertEquals(testArray.getY(5), 50);

        //Проверим все значения valuesX и valuesY еще раз
        for (int i = 0; i <= 5; i++) {
            assertEquals(testArray.getX(i), i);
            assertEquals(testArray.getY(i), i * 10);
        }
        assertEquals(testArray.getCount(), 7);
    }

    @Test
    public void testIteratorWhile() {
        TabulatedFunction testDefinedThroughArrays = getDefinedThroughArrays();
        Iterator<Point> myIterator = testDefinedThroughArrays.iterator();
        int i = 0;
        while (myIterator.hasNext()) {
            Point myPoint = myIterator.next();
            assertEquals(testDefinedThroughArrays.getX(i), myPoint.x, DELTA);
            assertEquals(testDefinedThroughArrays.getY(i++), myPoint.y, DELTA);
        }
        assertEquals(testDefinedThroughArrays.getCount(), i);

        TabulatedFunction testDefinedThroughMathFunction = getDefinedThroughMathFunction();
        myIterator = testDefinedThroughMathFunction.iterator();
        i = 0;
        while (myIterator.hasNext()) {
            Point myPoint = myIterator.next();
            assertEquals(testDefinedThroughMathFunction.getX(i), myPoint.x, DELTA);
            assertEquals(testDefinedThroughMathFunction.getY(i++), myPoint.y, DELTA);
        }
        assertEquals(testDefinedThroughMathFunction.getCount(), i);
        assertThrows(NoSuchElementException.class, myIterator::next);

    }

    @Test
    public void testIteratorForEach() {
        TabulatedFunction testDefinedThroughArrays = getDefinedThroughArrays();
        int i = 0;
        for (Point myPoint : testDefinedThroughArrays) {
            assertEquals(myPoint.x, testDefinedThroughArrays.getX(i), DELTA);
            assertEquals(myPoint.y, testDefinedThroughArrays.getY(i++), DELTA);
        }
        assertEquals(testDefinedThroughArrays.getCount(), i);

        TabulatedFunction testDefinedThroughMathFunction = getDefinedThroughMathFunction();
        i = 0;
        for (Point myPoint : testDefinedThroughMathFunction) {
            assertEquals(myPoint.x, testDefinedThroughMathFunction.getX(i), DELTA);
            assertEquals(myPoint.y, testDefinedThroughMathFunction.getY(i++), DELTA);
        }
        assertEquals(testDefinedThroughMathFunction.getCount(), i);
    }
}
