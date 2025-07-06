package org.example.service.impl;

import org.example.service.Logger;
import org.springframework.stereotype.Service;

@Service
public class ConsoleLoggerImpl implements Logger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
