package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
//
//        1) Predicate

        Predicate<Integer> isEven = i -> i % 2 == 0;
        Predicate<Integer> isOdd = i -> i % 2 == 1;
        Predicate<Integer> isPositive = i -> i > 0;
        Predicate<Integer> isNegative = i -> i < 0;
        Predicate<Integer> isZero = i -> i == 0;
//        2) Consumer
        Consumer<String> printResult = System.out::println;

//        3) Supplier
        Supplier<Integer> readNumberFromConsole = () -> {
            Scanner scanner = new Scanner(System.in);
            int number = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Please enter an integer: ");
                    number = scanner.nextInt();
                    validInput = true;  // Если дошли до этой точки, значит ввод правильный
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine();  // Очистка буфера ввода
                }
            }

            return number;
        };
//        4) Function
        Function<Integer, String> analizer = number -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Analizing number ").append(number).append("\n");
            sb.append("Is Even: ").append(isEven.test(number)).append("\n");
            sb.append("Is Odd: ").append(isOdd.test(number)).append("\n");
            sb.append("Is Positive: ").append(isPositive.test(number)).append("\n");
            sb.append("Is Negative: ").append(isNegative.test(number)).append("\n");
            sb.append("Is Zero: ").append(isZero.test(number)).append("\n");
            return sb.toString();
        };

        int number = readNumberFromConsole.get();
        String analized = analizer.apply(number);
        printResult.accept(analized);

    }
}