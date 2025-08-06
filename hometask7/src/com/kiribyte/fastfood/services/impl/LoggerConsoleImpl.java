package com.kiribyte.fastfood.services.impl;

import com.kiribyte.fastfood.models.Order;
import com.kiribyte.fastfood.services.interfaces.ILoggerService;
import com.kiribyte.fastfood.utils.DateTimeUtils;


public class LoggerConsoleImpl implements ILoggerService {

    private String RED = "\u001B[31m";
    private String GREEN = "\u001B[32m";
    private String RESET = "\u001B[0m";

    @Override
    public void log(String message) {
        System.out.println(DateTimeUtils.getCurrentDateTime() + " " + GREEN + message + RESET);
    }

    @Override
    public void logOrderStatus(Order order) {
        System.out.println(DateTimeUtils.getCurrentDateTime() + " " + RED + order.getId() + " is " + order.getStatus() + RESET);
    }

}
