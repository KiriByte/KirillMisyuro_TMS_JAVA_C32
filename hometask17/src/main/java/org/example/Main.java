package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        var random = new Random();
        var numbers = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            numbers.add(random.nextInt(21));
        }
        System.out.println(numbers);


//        1) вывести только четные
        List<Integer> onlyEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("Only Even: " + onlyEven);
//        2) получить коллекцию без дубликатов (используя distinct)
        List<Integer> withoutDuplicates = numbers.stream()
                .distinct()
                .toList();
        System.out.println("Without Duplicates: " + withoutDuplicates);
//        3) получить сумму всех чисел
        Integer sumNumbers = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sumNumbers);
//        4) получить максимальный элемент в коллекции
        Integer maxValue = numbers.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("Max: " + maxValue);
//        5) найти первый элемент, который больше 10
        Optional<Integer> first = numbers.stream()
                .filter(x -> x > 10)
                .findFirst();
        first.ifPresentOrElse(
                value -> System.out.println("First element greater than 10: " + value),
                () -> System.out.println("No element found that could be greater than 10"));

//        6) определить все ли числа делятся на 10 без остатка
        boolean allMatch = numbers.stream()
                .allMatch(x -> x % 10 == 0);
        if (allMatch) {
            System.out.println("All numbers div by 10");
        } else {
            System.out.println("Not all numbers div by 10");
        }
        var string = "Имеется коллекция строк. При помощи stream api необходимо";
        List<String> words = new ArrayList<>();
        words = Arrays.stream(string.split(" ")).toList();
        System.out.println(words);
//
//        1) получить коллекцию чисел, каждой число которого - длинна строки исходной коллекции
        List<Integer> lenghtsWords = words.stream()
                .map(String::length)
                .toList();
        System.out.println(lenghtsWords);
//        2) получить коллекцию строк где все элементы приведены к верхнему регистру
        List<String> wordsToUpperCase = words.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(wordsToUpperCase);
//        3) получить коллекцию строк, в которой нет элементов с буквой "a"
        List<String> wordsWithoutA = words.stream()
                .filter(s -> !s.toLowerCase().contains("a"))
                .toList();
        System.out.println(wordsWithoutA);

    }


}