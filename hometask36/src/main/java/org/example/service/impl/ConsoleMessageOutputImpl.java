package org.example.service.impl;

import org.example.service.MessageOutput;
import org.springframework.stereotype.Service;

@Service
public class ConsoleMessageOutputImpl implements MessageOutput {

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
