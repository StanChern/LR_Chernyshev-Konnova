package ru.ssau.tk.chernyshev_konnova.concurrent;

import ru.ssau.tk.chernyshev_konnova.functions.*;

public class ReadWriteTask implements Runnable {
    private final TabulatedFunction function;

    ReadWriteTask(TabulatedFunction function) {
        this.function = function;
    }

    @Override
    public void run() {
        for (int i = 0; i < function.getCount(); i++) {
            double x = function.getX(i);
            double y;
            synchronized (function) {
                y = function.getY(i);
                System.out.println(Thread.currentThread().getName() + ", before write: i = " + i + ", x = " + x + ", y = " + y);
                function.setY(i, y + 1);
                y = function.getY(i);
            }
            System.out.println(Thread.currentThread().getName() + ", after write: i = " + i + ", x = " + x + ", y = " + y + "\n");
        }
    }
}
