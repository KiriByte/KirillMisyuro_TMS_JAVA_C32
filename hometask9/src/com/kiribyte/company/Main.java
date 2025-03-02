package com.kiribyte.company;

import com.kiribyte.company.model.Director;
import com.kiribyte.company.model.Worker;
import com.kiribyte.company.service.IEmployeeFinder;
import com.kiribyte.company.service.Impl.EmployeeFinderImpl;

public class Main {
    public static void main(String[] args) {

        // Directors
        var director1 = new Director("Mikhail", "Petrov", 12);
        var director2 = new Director("Vladimir", "Ivanov", 15);

        // Workers
        var worker1 = new Worker("Elena", "Smirnova", 5);
        var worker2 = new Worker("Dmitriy", "Kuznetsov", 3);
        var worker3 = new Worker("Anatoly", "Sokolov", 7);

        director1.addSubordinate(worker1);
        director1.addSubordinate(worker2);
        director2.addSubordinate(worker3);
        director1.addSubordinate(director2);

        System.out.println(director1);
        System.out.println(director2);
        System.out.println(worker3);

        IEmployeeFinder employeeFinder = new EmployeeFinderImpl();
        System.out.println(employeeFinder.findEmployeeByName(director1, "Elena"));
        System.out.println(employeeFinder.findEmployeeBySurname(director2, "Sokolov"));


    }
}