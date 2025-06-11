package com.kiribyte.threads.Task2;

public class MaxValueThread implements Runnable {
    private final int[] array;
    private int maxValue;

    public MaxValueThread(int[] array) {
        this.array = array;
        this.maxValue = Integer.MIN_VALUE;
    }

    @Override
    public void run() {

        for (var value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
    }

    public int getMaxValue() {
        return maxValue;
    }


}
