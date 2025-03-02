package com.kiribyte.employers.model;

public class EmployeeNew extends Employee {

    @Override
    public double getSalary() {
        double increasedBaseSalary = getPosition().getBaseSalary() * 1.2;
        return increasedBaseSalary * (1 + getYearsOfExperience() * 0.1);
    }
}
