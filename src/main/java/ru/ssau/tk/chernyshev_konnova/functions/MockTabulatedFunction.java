package ru.ssau.tk.chernyshev_konnova.functions;

public class MockTabulatedFunction extends AbstractTabulatedFunction {

    private static final double X0 = 1;
    private static final double X1 = 3;
    private static final double Y0 = 5;
    private static final double Y1 = 7;

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public double getX(int index) {
        if (index == 1) {
            return (X1);
        }
        return (X0);
    }

    @Override
    public double getY(int index) {
        if (index == 1) {
            return (Y1);
        }
        return (Y0);
    }

    @Override
    public void setY(int index, double value) {
        //Nothing???
    }

    @Override
    public int indexOfX(double x) {
        if (x == X1) {
            return (1);
        }
        if (x == X0) {
            return (0);
        } else return (-1);
    }

    @Override
    public int indexOfY(double y) {
        if (y == Y1) {
            return (1);
        }
        if (y == Y0) {
            return (0);
        } else return (-1);
    }

    @Override
    public double leftBound() {
        return X0;
    }

    @Override
    public double rightBound() {
        return X1;
    }

    @Override
    protected int floorIndexOfX(double x) {
        if (x == X1) {
            return (1);
        }
        if (x > X1) {
            return (2);
        } else return (0);
    }

    @Override
    protected double extrapolateLeft(double x) {
        return interpolate(x, X0, X1, Y0, Y1);
    }

    @Override
    protected double extrapolateRight(double x) {
        return interpolate(x, X0, X1, Y0, Y1);
    }

    @Override
    protected double interpolate(double x, int floorIndex) {
        return interpolate(x, X0, X1, Y0, Y1);
    }
}
