package com.kiribyte.threads.Task2;

import com.kiribyte.threads.IAppRunner;

import java.util.Arrays;
import java.util.Random;

public class Task2 implements IAppRunner {

    @Override
    public void run() {
        var array = getArray();
        System.out.println("Array: " + Arrays.toString(array));
        var maxValueThread = new MaxValueThread(array);
        var minValueThread = new MinValueThread(array);

        Thread thread1 = new Thread(maxValueThread);
        Thread thread2 = new Thread(minValueThread);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Max value: " + maxValueThread.getMaxValue());
        System.out.println("Min value: " + minValueThread.getMinValue());
    }

    private int[] getArray() {

        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        return arr;
    }

}
