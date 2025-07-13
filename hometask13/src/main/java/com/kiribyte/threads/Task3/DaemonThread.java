package com.kiribyte.threads.Task3;

public class DaemonThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Daemon thread started");
        var i = 0;
        while (true) {
            try {
                System.out.println(i++);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
