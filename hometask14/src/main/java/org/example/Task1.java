package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Task1 {

    public void run() {
        var numbers = new ArrayList<Integer>();
        var evenNumbers = new ArrayList<Integer>();

        for (int i = 0; i < 20; i++) {
            numbers.add(new Random().nextInt(100));
        }

        for (var value : numbers) {
            if (value % 2 == 0) {
                evenNumbers.add(value);
            }
        }
        System.out.println(numbers);
        System.out.println(evenNumbers);
    }
}
