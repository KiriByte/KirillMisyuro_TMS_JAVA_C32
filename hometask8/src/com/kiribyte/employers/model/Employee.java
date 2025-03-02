package com.kiribyte.employers.model;


public class Employee {

    private String name;
    private int yearsOfExperience;
    private Position position;

    public String getName() {
        return name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public Position getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSalary() {
        return position.getBaseSalary() * (1 + yearsOfExperience * 0.1);
    }
}
