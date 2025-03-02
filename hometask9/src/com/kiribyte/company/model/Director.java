package com.kiribyte.company.model;


import lombok.Getter;

public class Director extends Employee {
    @Getter
    private Employee[] subordinates;
    @Getter
    private int subordinatesCount;
    private final static int MAXSUBORDINATES = 10;

    public Director(String name, String surname, int yearsOfExperience) {
        super(name, surname, yearsOfExperience);
        this.setPosition(Position.DIRECTOR);
        this.subordinates = new Employee[MAXSUBORDINATES];
        this.subordinatesCount = 0;
    }

    public void addSubordinate(Employee employee) {
        if (subordinatesCount < MAXSUBORDINATES) {
            subordinates[subordinatesCount] = employee;
            subordinatesCount++;
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("Full Name: ").append(getName()).append(" ").append(getSurname()).append("\n");
        sb.append("Experience: ").append(getYearsOfExperience()).append(" years\n");
        sb.append("Position: ").append(getPosition()).append("\n");
        sb.append("Subordinate Count: ").append(subordinatesCount).append("\n");

        if (subordinatesCount > 0) {
            sb.append("Subordinates: ").append("\n");
            for (int i = 0; i < subordinatesCount; i++) {
                sb.append(subordinates[i]);
            }
        }
        return sb.toString();
    }


}
