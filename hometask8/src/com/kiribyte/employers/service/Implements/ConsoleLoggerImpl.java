package com.kiribyte.employers.service.Implements;

import com.kiribyte.employers.service.ILogger;

public class ConsoleLoggerImpl implements ILogger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
