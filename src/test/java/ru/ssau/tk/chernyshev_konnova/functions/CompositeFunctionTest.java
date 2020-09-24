package ru.ssau.tk.chernyshev_konnova.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class CompositeFunctionTest {

    private final static double DELTA = 0.00001;

    @Test
    public void testApply() {
        MathFunction identityFunction = new IdentityFunction();
        MathFunction lnFunction = new LnFunction();
        MathFunction doubleIdentityFunction = new CompositeFunction(identityFunction, identityFunction);
        assertEquals(doubleIdentityFunction.apply(1), 1, DELTA);

        MathFunction identityLnFunction = new CompositeFunction(identityFunction, lnFunction);
        assertEquals(identityLnFunction.apply(1), 0, DELTA);

        MathFunction sqrFunction = new SqrFunction();
        MathFunction unitFunction = new UnitFunction();
        MathFunction sqrLnUnitFunction = sqrFunction.andThen(lnFunction).andThen(unitFunction);
        assertEquals(sqrLnUnitFunction.apply(4), 1, DELTA);
        assertNotEquals(sqrLnUnitFunction.apply(1), 0, DELTA);
        assertEquals(sqrLnUnitFunction.apply(1651), 1, DELTA);

        double result = lnFunction.andThen(sqrFunction).andThen(identityFunction).apply(100);
        assertEquals(result, 21.2075924, DELTA);
        assertNotEquals(result, 100, DELTA);
        assertNotEquals(result, 1, DELTA);
    }
}