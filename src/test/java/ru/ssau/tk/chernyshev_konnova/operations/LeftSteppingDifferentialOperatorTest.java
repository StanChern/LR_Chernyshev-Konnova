package ru.ssau.tk.chernyshev_konnova.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.functions.simple.SqrFunction;

import static org.testng.Assert.*;
import static ru.ssau.tk.chernyshev_konnova.functions.SomeConstants.*;

public class LeftSteppingDifferentialOperatorTest {

    @Test
    public void testDerive() {
        SteppingDifferentialOperator differentialOperator = new LeftSteppingDifferentialOperator(step);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(1), 1.99, DELTA);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(2), 3.99, DELTA);
    }
}