package com.kiribyte.threads;

import com.kiribyte.threads.Task1.CustomThread;
import com.kiribyte.threads.Task1.RunnableTask;
import com.kiribyte.threads.Task1.Task1;
import com.kiribyte.threads.Task2.Task2;
import com.kiribyte.threads.Task3.Task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Choose task");
        int choice = new Scanner(System.in).nextInt();

        IAppRunner app = null;

        try {
            app = selectAppRunner(choice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        app.run();


    }

    public static IAppRunner selectAppRunner(int choice) throws IllegalArgumentException {

        return switch (choice) {
            case 1 -> new Task1();
            case 2 -> new Task2();
            case 3 -> new Task3();
            default -> throw new IllegalArgumentException("Unknown argument: " + choice);
        };
    }
}