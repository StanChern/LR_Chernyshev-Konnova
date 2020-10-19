package ru.ssau.tk.chernyshev_konnova.functions;

import ru.ssau.tk.chernyshev_konnova.exceptions.*;

public abstract class AbstractTabulatedFunction implements TabulatedFunction {

    protected int count;

    public abstract int getCount();

    protected abstract int floorIndexOfX(double x);

    protected abstract double extrapolateLeft(double x);

    protected abstract double extrapolateRight(double x);

    protected abstract double interpolate(double x, int floorIndex);

    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return (leftY + (x - leftX) * (rightY - leftY) / (rightX - leftX));
    }

    public double apply(double x) {
        int index = indexOfX(x);

        if (x < leftBound()) {
            return (extrapolateLeft(x));
        }
        if (x > rightBound()) {
            return (extrapolateRight(x));
        }
        if (index != -1) {
            return (getY(index));
        }
        return (interpolate(x, floorIndexOfX(x)));
    }

    static void checkLengthIsTheSame(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length) {
            throw new DifferentLengthOfArraysException("Lengths of xValues and yValues are different");
        }
    }

    static void checkSorted(double[] xValues) {
        for (int i = 0; i < xValues.length - 1; i++) {
            if (xValues[i + 1] < xValues[i]) {
                throw new ArrayIsNotSortedException("xValues is not sort");
            }
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getClass().getSimpleName()).append(" size = ").append(count).append("\n");

        for (Point point : this) {
            str.append("[")
                    .append(point.x)
                    .append("; ")
                    .append(point.y)
                    .append("]\n");
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }

}
