package com.kiribyte.company.service;

import com.kiribyte.company.model.Director;
import com.kiribyte.company.model.Employee;

public interface IEmployeeFinder {
    boolean findEmployeeByName(Director director, String employeeName);

    boolean findEmployeeBySurname(Director director, String employeeSurname);
}
