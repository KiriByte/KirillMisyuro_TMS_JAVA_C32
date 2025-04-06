package com.kiribyte.io.services.impl;

import com.kiribyte.io.services.ILogger;

public class ConsoleLoggerImpl implements ILogger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
