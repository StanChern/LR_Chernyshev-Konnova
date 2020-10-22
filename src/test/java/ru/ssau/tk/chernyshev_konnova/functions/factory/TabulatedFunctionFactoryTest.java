package ru.ssau.tk.chernyshev_konnova.functions.factory;

import org.testng.annotations.Test;
import ru.ssau.tk.chernyshev_konnova.functions.*;

import static org.testng.Assert.*;

public class TabulatedFunctionFactoryTest {

    @Test
    public void testCreateStrictAndUnmodifiable() {
        double[] x = {1, 2, 3, 4};
        double[] y = {10, 20, 30, 40};

        TabulatedFunctionFactory listFactory = new LinkedListTabulatedFunctionFactory();
        TabulatedFunction strictListFunction = listFactory.createStrict(x, y);
        assertTrue(strictListFunction instanceof StrictTabulatedFunction);

        TabulatedFunctionFactory arrayFactory = new LinkedListTabulatedFunctionFactory();
        TabulatedFunction strictArrayFunction = arrayFactory.createStrict(x, y);
        assertTrue(strictArrayFunction instanceof StrictTabulatedFunction);

        TabulatedFunctionFactory listFactory1 = new LinkedListTabulatedFunctionFactory();
        TabulatedFunction unmodifiableListFunction = listFactory1.createUnmodifiable(x, y);
        assertTrue(unmodifiableListFunction instanceof UnmodifiableTabulatedFunction);

        TabulatedFunctionFactory arrayFactory1 = new LinkedListTabulatedFunctionFactory();
        TabulatedFunction unmodifiableArrayFunction = arrayFactory1.createUnmodifiable(x, y);
        assertTrue(unmodifiableArrayFunction instanceof UnmodifiableTabulatedFunction);

        /*В данном случае вынуждены проверять немодифицируемость через отлов исключений,
         т.к. результатом работы метода createStrictUnmodifiable() будет функция типа StrictTabulatedFunction,
         но она в соответствии с заданием будет обладать свойствами обейих оберток*/

        TabulatedFunctionFactory listFactory2 = new LinkedListTabulatedFunctionFactory();
        TabulatedFunction strictUnmodifiableListFunction = listFactory2.createStrictUnmodifiable(x, y);
        assertTrue(strictUnmodifiableListFunction instanceof StrictTabulatedFunction);
        assertThrows(UnsupportedOperationException.class, () -> strictUnmodifiableListFunction.setY(0, 0));

        TabulatedFunctionFactory arrayFactory2 = new LinkedListTabulatedFunctionFactory();
        TabulatedFunction strictUnmodifiableArrayFunction = arrayFactory2.createStrictUnmodifiable(x, y);
        assertTrue(strictUnmodifiableArrayFunction instanceof StrictTabulatedFunction);
        assertThrows(UnsupportedOperationException.class, () -> strictUnmodifiableArrayFunction.setY(1, 0));
    }
}