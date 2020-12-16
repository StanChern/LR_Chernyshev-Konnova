package ru.ssau.tk.chernyshev_konnova.concurrent;

import ru.ssau.tk.chernyshev_konnova.functions.TabulatedFunction;


public class MultiplyingTask implements Runnable {
    private final TabulatedFunction function;
    Runnable postRunAction;

    public MultiplyingTask(TabulatedFunction func) {
        this.function = func;
    }

    public MultiplyingTask(TabulatedFunction func, Runnable postRunAction) {
        this.function = func;
        this.postRunAction = postRunAction;
    }

    @Override
    public void run() {
        double x;
        double y;
        for (int i = 0; i < function.getCount(); i++) {
            x = function.getX(i);
            synchronized (function) {
                y = function.getY(i);
                System.out.println(Thread.currentThread().getName() + ", before write: i = " + i + ", x = " + x + ", y = " + y);
                function.setY(i, y * 10);
                y = function.getY(i);
            }
            System.out.println(Thread.currentThread().getName() + ", after write: i = " + i + ", x = " + x + ", y = " + y + "\n");
        }
    }
}