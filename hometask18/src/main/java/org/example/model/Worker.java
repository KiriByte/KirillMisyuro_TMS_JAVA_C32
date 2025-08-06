package org.example.model;

import lombok.Data;

@Data
public class Worker {

    private String name;
    private Position position;
    private int salary;

    public Worker(String name, Position position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}
