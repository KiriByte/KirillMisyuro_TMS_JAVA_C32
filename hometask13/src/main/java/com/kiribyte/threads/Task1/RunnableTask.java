package com.kiribyte.threads.Task1;

public class RunnableTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            System.out.println("MyRunnable is running: " + i);
            try {
                Thread.sleep(500); // Имитация работы
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
