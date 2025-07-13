package com.kiribyte.threads.Task1;

import com.kiribyte.threads.IAppRunner;

public class Task1 implements IAppRunner {

    @Override
    public void run() {
        CustomThread t1 = new CustomThread();
        Thread t2 = new Thread(new RunnableTask());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
