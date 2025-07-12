package org.example.service.impl;

import org.example.service.HorseService;
import org.example.service.MessageOutput;
import org.springframework.stereotype.Service;

@Service
public class HorseServiceImpl implements HorseService {

    private int horseCount = 3;

    private final MessageOutput messageOutput;

    public HorseServiceImpl(MessageOutput messageOutput) {
        this.messageOutput = messageOutput;
    }

    @Override
    public int setHorseCount(int horseCount) {
        this.horseCount = horseCount;
        return this.horseCount;
    }

    @Override
    public void displayHorses() {
        messageOutput.write("Horses in race: ");
        for (int i = 1; i <= horseCount; i++) {
            messageOutput.write("Horse #" + i);
        }
    }
}
