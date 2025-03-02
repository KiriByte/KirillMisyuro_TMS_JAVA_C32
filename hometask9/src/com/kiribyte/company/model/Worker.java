package com.kiribyte.company.model;

public class Worker extends Employee {
    public Worker(String name, String surname, int yearsOfExperience) {
        super(name, surname, yearsOfExperience);
        this.setPosition(Position.WORKER);
    }
}
