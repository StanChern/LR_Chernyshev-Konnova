package ru.ssau.tk.chernyshev_konnova.functions;

public interface TabulatedFunction extends MathFunction {

    int getCount();

    double getX(int index);

    double getY(int index);

    void setY(int index, double value);

    int indexOfX(double x);

    int indexOfY(double y);

    double leftBound();

    double rightBound();
}
/*TODO:Стас 1) написать MockTabulatedFunction       done
            2) понять как работает со списком       done
            3) создать интерфейс удаления/вставки
            4) написать вставку для листа
            5) написать удаление для листа
            6) вынести DELTA
 */
