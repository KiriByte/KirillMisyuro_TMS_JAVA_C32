package com.kiribyte.employers.model;

public enum Position {
    MANAGER(1000),
    WAREHOUSE_WORKER(800),
    CLEANER(500);

    private final double baseSalary;

    Position(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}
