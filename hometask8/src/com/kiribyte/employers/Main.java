package com.kiribyte.employers;

import com.kiribyte.employers.model.*;
import com.kiribyte.employers.service.*;
import com.kiribyte.employers.service.Implements.ConsoleLoggerImpl;
import com.kiribyte.employers.service.Implements.EmployeeServiceImpl;

public class Main {
    public static void main(String[] args) {

        ILogger logger = new ConsoleLoggerImpl();
        IEmployeeService employeeService = new EmployeeServiceImpl(logger);


        var employee = new Employee();
        employee.setName("Ivan");
        employee.setPosition(Position.MANAGER);
        employee.setYearsOfExperience(5);

        var employee1 = new EmployeeNew();
        employee1.setName("Oleg");
        employee1.setPosition(Position.MANAGER);
        employee1.setYearsOfExperience(5);

        employeeService.logSalary(employee);
        employeeService.logSalary(employee1);
    }
}