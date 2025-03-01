package com.kiribyte.company.model;

public class Director extends Employee {
    private Employee[] subordinates;
    private int subordinatesCount;
    private final static int MAXSUBORDINATES = 10;

    public Director(String name, String surname, int yearsOfExperience) {
        super(name, surname, yearsOfExperience);
        this.setPosition(Position.DIRECTOR);
        this.subordinates = new Employee[MAXSUBORDINATES];
        this.subordinatesCount = 0;
    }

    public void addSubordinate(Employee e) {
        if (subordinatesCount < MAXSUBORDINATES) {
            subordinates[subordinatesCount] = e;
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
            sb.append("Subordinates: ");
            for (int i = 0; i < subordinatesCount; i++) {
                sb.append(subordinates[i]).append(", ");
            }
        }

        return sb.toString();
    }


}
