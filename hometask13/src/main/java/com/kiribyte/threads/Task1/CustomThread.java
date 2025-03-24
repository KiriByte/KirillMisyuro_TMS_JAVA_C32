package com.kiribyte.threads.Task1;

public class CustomThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 60; i++) {
            System.out.println("extendsTask1 is running: " + i);
            try {
                Thread.sleep(1000); // Имитация работы
            } catch (InterruptedException e) {
                System.out.println("extendsTask1 interrupted");
            }
        }
    }
}
