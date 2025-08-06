package com.kiribyte.threads.Task2;

public class MinValueThread implements Runnable {

    private final int[] array;
    private int minValue;

    public MinValueThread(int[] array) {
        this.array = array;
        this.minValue = Integer.MAX_VALUE;
    }

    @Override
    public void run() {

        for (var value : array) {
            if (value < minValue) {
                minValue = value;
            }
        }
    }

    public int getMinValue() {
        return minValue;
    }
}
