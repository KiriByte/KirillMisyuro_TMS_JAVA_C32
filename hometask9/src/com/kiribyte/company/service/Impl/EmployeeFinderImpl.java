package com.kiribyte.company.service.Impl;

import com.kiribyte.company.model.Director;
import com.kiribyte.company.service.IEmployeeFinder;

public class EmployeeFinderImpl implements IEmployeeFinder {
    @Override
    public boolean findEmployeeByName(Director director, String employeeName) {

        for (int i = 0; i < director.getSubordinatesCount(); i++) {
            var subordinate = director.getSubordinates()[i];

            if (subordinate.getName().equals(employeeName)) {
                return true;
            }

            if (subordinate instanceof Director) {
                if (findEmployeeByName((Director) subordinate, employeeName)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean findEmployeeBySurname(Director director, String employeeSurname) {
        for (int i = 0; i < director.getSubordinatesCount(); i++) {
            var subordinate = director.getSubordinates()[i];

            if (subordinate.getSurname().equals(employeeSurname)) {
                return true;
            }

            if (subordinate instanceof Director) {
                if (findEmployeeByName((Director) subordinate, employeeSurname)) {
                    return true;
                }
            }
        }
        return false;
    }


}
