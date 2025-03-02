package com.kiribyte.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Employee {
    private final String name;
    private final String surname;
    private final int yearsOfExperience;
    private Position position;

    public Employee(String name, String surname, int yearsOfExperience) {
        this.name = name;
        this.surname = surname;
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("Full Name: ").append(name).append(" ").append(surname).append("\n");
        sb.append("Experience: ").append(yearsOfExperience).append(" years\n");
        sb.append("Position: ").append(position).append("\n");
        return sb.toString();
    }
}
