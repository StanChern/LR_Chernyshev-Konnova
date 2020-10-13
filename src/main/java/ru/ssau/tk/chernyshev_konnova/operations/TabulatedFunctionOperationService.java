package ru.ssau.tk.chernyshev_konnova.operations;

import ru.ssau.tk.chernyshev_konnova.functions.*;

public class TabulatedFunctionOperationService {
    public static Point[] asPoints(TabulatedFunction tabulatedFunction) {
        int i = 0;
        Point[] points = new Point[tabulatedFunction.getCount()];
        for (Point point : tabulatedFunction) {
            points[i++] = point;
        }
        return points;
    }
}
