package ru.ssau.tk.chernyshev_konnova.concurrent;

import ru.ssau.tk.chernyshev_konnova.functions.*;
import ru.ssau.tk.chernyshev_konnova.functions.simple.ConstantFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class AddingMultiplyingTaskExecutor {
    public static void main(String[] args) throws InterruptedException {
        TabulatedFunction listFunction = new LinkedListTabulatedFunction(new ConstantFunction(2), 1, 100, 10);
        List<Thread> myThread = new ArrayList<>();

        myThread.add(new Thread(new MultiplyingTask(listFunction)));
        myThread.add(new Thread(new MultiplyingTask(listFunction)));
        myThread.add(new Thread(new AddingTask(listFunction)));

        for (Thread i : myThread) {
            i.start();
        }

        Thread.sleep(2_000);
        System.out.println(listFunction.toString());
    }
}