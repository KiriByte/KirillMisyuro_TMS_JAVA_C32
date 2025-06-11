package org.example;

import org.example.model.Position;
import org.example.model.Worker;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

//        Есть список сотрудников компании. Каждый сотрудник обладает следующими полями (профессия - enum, величина зп).
//        При помощи стрима и методов группировки необходимо узнать
        var positions = Position.values();
        Random random = new Random();
        var workers = new ArrayList<Worker>();

        for (int i = 0; i < 10; i++) {
            var name = "Worker " + i;
            var position = positions[random.nextInt(positions.length)];
            var salary = 500 + random.nextInt(1500);

            workers.add(new Worker(name, position, salary));
        }

        for (var worker : workers) {
            System.out.println(worker.toString());
        }
//
//        1) Среднюю зп по профессиям
//
        Map<Position, Double> avrSalaries = workers.stream()
                .collect(Collectors.groupingBy(
                        Worker::getPosition,
                        Collectors.averagingInt(Worker::getSalary)
                ));

        System.out.println("\nAverage Salaries:");
//        for (var salary : avrSalaries.entrySet()) {
//            System.out.println(salary.getKey() + " " + salary.getValue());
//        }
        avrSalaries.forEach((position, salary) -> System.out.println(position + " " + salary));
//        2) Сколько работников относится к каждой из профессий
        Map<Position, Long> positionsCount = workers.stream()
                .collect(Collectors.groupingBy(
                        Worker::getPosition,
                        Collectors.counting()
                ));
        System.out.println("\nPeople on positions:");
        positionsCount.forEach((position, count) -> System.out.println(position + " " + count));
//        3) Сколько компания тратит денег на зп каждой профессии
        Map<Position, Integer> positionsSalary = workers.stream()
                .collect(Collectors.groupingBy(
                        Worker::getPosition,
                        Collectors.summingInt(Worker::getSalary)
                ));
        System.out.println("\nSalary on positions:");
        positionsSalary.forEach((position, salary) -> System.out.println(position + " " + salary));
    }
}