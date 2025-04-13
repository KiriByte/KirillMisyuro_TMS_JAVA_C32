package com.kiribyte.threads.Task3;

import com.kiribyte.threads.IAppRunner;

public class Task3 implements IAppRunner {

    @Override
    public void run() {
        Thread daemon = new Thread(new DaemonThread(), "DaemonThread");
        daemon.setDaemon(false);
        daemon.start();

        System.out.println("Task3 thread started");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Task3 thread interrupted");
        }
        System.out.println("Task3 thread Finished");
    }
}
