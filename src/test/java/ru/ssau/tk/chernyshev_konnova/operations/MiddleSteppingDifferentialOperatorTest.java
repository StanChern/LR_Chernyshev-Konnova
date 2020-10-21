package ru.ssau.tk.chernyshev_konnova.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.functions.SqrFunction;

import static org.testng.Assert.*;
import static ru.ssau.tk.chernyshev_konnova.functions.SomeConstants.*;

public class MiddleSteppingDifferentialOperatorTest {

    @Test
    public void testDerive() {
        SteppingDifferentialOperator differentialOperator = new RightSteppingDifferentialOperator(step);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(1), 2, DELTA);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(2), 4, DELTA);
    }
}