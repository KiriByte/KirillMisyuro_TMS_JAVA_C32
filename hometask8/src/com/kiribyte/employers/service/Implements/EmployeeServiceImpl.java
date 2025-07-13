package com.kiribyte.employers.service.Implements;

import com.kiribyte.employers.model.Employee;
import com.kiribyte.employers.service.IEmployeeService;
import com.kiribyte.employers.service.ILogger;

public class EmployeeServiceImpl implements IEmployeeService {

    private final ILogger logger;

    public EmployeeServiceImpl(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void logSalary(Employee employee) {
        logger.log(employee.getName() + ": " + employee.getSalary());
    }

}
