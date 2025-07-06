package org.example.service.impl;

import org.example.service.HorseService;
import org.example.service.Logger;
import org.springframework.stereotype.Service;

@Service
public class HorseServiceImpl implements HorseService {

    private int defaultHorseCount = 3;

    private final Logger logger;

    public HorseServiceImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public int getHorseCount() {
        return defaultHorseCount;
    }

    @Override
    public int setHorseCount(int horseCount) {
        defaultHorseCount = horseCount;
        return defaultHorseCount;
    }


    @Override
    public void displayHorses() {
        logger.log("Horses in race: ");
        for (int i = 1; i <= defaultHorseCount; i++) {
            logger.log("Horse #" + i);
        }
    }
}
