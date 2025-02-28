package com.kiribyte.employers.model;


public class Employee {

    private String Name;
    private int yearsOfExperience;
    private Position position;

    public String getName() {
        return Name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public Position getPosition() {
        return position;
    }

    public void setName(String name) {
        Name = name;
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
