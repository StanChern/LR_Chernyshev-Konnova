package ru.ssau.tk.chernyshev_konnova.concurrent;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.functions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.testng.Assert.*;
import static ru.ssau.tk.chernyshev_konnova.functions.SomeConstants.DELTA;

public class SynchronizedTabulatedFunctionTest {
    private final double[] x = new double[]{1, 2, 3, 4, 5};
    private final double[] y = new double[]{10, 20, 30, 40, 50};
    private final Object sync = new Object();

    private SynchronizedTabulatedFunction getSynchronizedLinkedListTabulatedFunction() {
        return new SynchronizedTabulatedFunction(new LinkedListTabulatedFunction(x, y), sync);
    }

    private SynchronizedTabulatedFunction getSynchronizedArrayTabulatedFunction() {
        return new SynchronizedTabulatedFunction(new ArrayTabulatedFunction(x, y), sync);
    }

    @Test
    public void testGetCount() {
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionList = getSynchronizedLinkedListTabulatedFunction();
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionArray = getSynchronizedArrayTabulatedFunction();

        assertEquals(synchronizedTabulatedFunctionArray.getCount(), 5, SomeConstants.DELTA);
        assertEquals(synchronizedTabulatedFunctionList.getCount(), 5, SomeConstants.DELTA);
    }

    @Test
    public void testGetX() {
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionList = getSynchronizedLinkedListTabulatedFunction();
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionArray = getSynchronizedArrayTabulatedFunction();

        for (int i = 0; i < synchronizedTabulatedFunctionArray.getCount(); i++) {
            assertEquals(synchronizedTabulatedFunctionArray.getX(i), i + 1, SomeConstants.DELTA);
            assertEquals(synchronizedTabulatedFunctionList.getX(i), i + 1, SomeConstants.DELTA);
        }
    }

    @Test
    public void testGetY() {
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionList = getSynchronizedLinkedListTabulatedFunction();
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionArray = getSynchronizedArrayTabulatedFunction();

        for (int i = 0; i < synchronizedTabulatedFunctionArray.getCount(); i++) {
            assertEquals(synchronizedTabulatedFunctionArray.getY(i), (i + 1) * 10, SomeConstants.DELTA);
            assertEquals(synchronizedTabulatedFunctionList.getY(i), (i + 1) * 10, SomeConstants.DELTA);
        }
    }

    @Test
    public void testSetY() {
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionList = getSynchronizedLinkedListTabulatedFunction();
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionArray = getSynchronizedArrayTabulatedFunction();

        for (int i = 0; i < synchronizedTabulatedFunctionArray.getCount(); i++) {
            synchronizedTabulatedFunctionList.setY(i, i + 1);
            synchronizedTabulatedFunctionArray.setY(i, i + 1);
        }

        for (int i = 0; i < synchronizedTabulatedFunctionArray.getCount(); i++) {
            assertEquals(synchronizedTabulatedFunctionArray.getY(i), i + 1, SomeConstants.DELTA);
            assertEquals(synchronizedTabulatedFunctionList.getY(i), i + 1, SomeConstants.DELTA);
        }
    }

    @Test
    public void testIndexOfX() {
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionList = getSynchronizedLinkedListTabulatedFunction();
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionArray = getSynchronizedArrayTabulatedFunction();

        for (int i = 0; i < synchronizedTabulatedFunctionArray.getCount(); i++) {
            assertEquals(synchronizedTabulatedFunctionArray.indexOfX(i + 1), i, SomeConstants.DELTA);
            assertEquals(synchronizedTabulatedFunctionList.indexOfX(i + 1), i, SomeConstants.DELTA);
        }
    }

    @Test
    public void testIndexOfY() {
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionList = getSynchronizedLinkedListTabulatedFunction();
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionArray = getSynchronizedArrayTabulatedFunction();

        for (int i = 0; i < synchronizedTabulatedFunctionArray.getCount(); i++) {
            assertEquals(synchronizedTabulatedFunctionArray.indexOfY((i + 1) * 10), i, SomeConstants.DELTA);
            assertEquals(synchronizedTabulatedFunctionList.indexOfY((i + 1) * 10), i, SomeConstants.DELTA);
        }
    }

    @Test
    public void testLeftBound() {
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionList = getSynchronizedLinkedListTabulatedFunction();
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionArray = getSynchronizedArrayTabulatedFunction();

        assertEquals(synchronizedTabulatedFunctionList.leftBound(), 1, SomeConstants.DELTA);
        assertEquals(synchronizedTabulatedFunctionArray.leftBound(), 1, SomeConstants.DELTA);
    }

    @Test
    public void testRightBound() {
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionList = getSynchronizedLinkedListTabulatedFunction();
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionArray = getSynchronizedArrayTabulatedFunction();

        assertEquals(synchronizedTabulatedFunctionList.rightBound(), 5, SomeConstants.DELTA);
        assertEquals(synchronizedTabulatedFunctionArray.rightBound(), 5, SomeConstants.DELTA);
    }

    @Test
    public void testIteratorForEach() {
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionList = getSynchronizedLinkedListTabulatedFunction();
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionArray = getSynchronizedArrayTabulatedFunction();
        int k = 0;
        for (Point myPoint : synchronizedTabulatedFunctionList) {
            assertEquals(myPoint.x, synchronizedTabulatedFunctionList.getX(k), DELTA);
            assertEquals(myPoint.y, synchronizedTabulatedFunctionList.getY(k++), DELTA);
        }
        assertEquals(synchronizedTabulatedFunctionList.getCount(), k);

        int s = 0;
        for (Point myPoint : synchronizedTabulatedFunctionArray) {
            assertEquals(myPoint.x, synchronizedTabulatedFunctionArray.getX(s), DELTA);
            assertEquals(myPoint.y, synchronizedTabulatedFunctionArray.getY(s++), DELTA);
        }
        assertEquals(synchronizedTabulatedFunctionArray.getCount(), s);

    }

    @Test
    public void testIteratorWhile() {
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionList = getSynchronizedLinkedListTabulatedFunction();
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionArray = getSynchronizedArrayTabulatedFunction();

        Iterator<Point> myIterator = synchronizedTabulatedFunctionList.iterator();
        int k = 0;
        while (myIterator.hasNext()) {
            Point myPoint = myIterator.next();
            assertEquals(synchronizedTabulatedFunctionList.getX(k), myPoint.x, DELTA);
            assertEquals(synchronizedTabulatedFunctionList.getY(k++), myPoint.y, DELTA);
        }
        assertEquals(synchronizedTabulatedFunctionList.getCount(), k);


        Iterator<Point> myIteratorToo = synchronizedTabulatedFunctionArray.iterator();
        int s = 0;
        while (myIteratorToo.hasNext()) {
            Point myPoint = myIteratorToo.next();
            assertEquals(myPoint.x, synchronizedTabulatedFunctionArray.getX(s), DELTA);
            assertEquals(myPoint.y, synchronizedTabulatedFunctionArray.getY(s++), DELTA);
        }
        assertEquals(synchronizedTabulatedFunctionArray.getCount(), s);
        assertThrows(NoSuchElementException.class, myIterator::next);
    }

    @Test
    public void testApply() {
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionList = getSynchronizedLinkedListTabulatedFunction();
        SynchronizedTabulatedFunction synchronizedTabulatedFunctionArray = getSynchronizedArrayTabulatedFunction();

        assertEquals(synchronizedTabulatedFunctionArray.apply(0), 0, SomeConstants.DELTA);
        assertEquals(synchronizedTabulatedFunctionList.apply(7), 70, SomeConstants.DELTA);
        assertEquals(synchronizedTabulatedFunctionArray.apply(6), 60, SomeConstants.DELTA);
    }

    @Test
    public void testDoSynchronously() {
        SynchronizedTabulatedFunction synchronizedTabulatedFunction = getSynchronizedLinkedListTabulatedFunction();
        assertEquals((int) synchronizedTabulatedFunction.doSynchronously(SynchronizedTabulatedFunction::getCount), 5);
        assertEquals(java.util.Optional.ofNullable(synchronizedTabulatedFunction.doSynchronously(SynchronizedTabulatedFunction::leftBound)), Optional.of(1.0));
    }
}