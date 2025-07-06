package org.example.service.impl;

import org.example.service.Logger;
import org.example.service.RaceService;
import org.example.service.RaceVisualizationService;
import org.springframework.stereotype.Service;

@Service
public class RaceServiceImpl implements RaceService {

    private final Logger logger;
    private final RaceVisualizationService visualizationService;

    public RaceServiceImpl(Logger logger,
                           RaceVisualizationService visualizationService) {
        this.logger = logger;
        this.visualizationService = visualizationService;
    }

    @Override
    public int startRace(int horseCount) {
        logger.log("Race start!");
        visualizationService.visualizeRace(horseCount);
        int winner = visualizationService.getWinner();
        logger.log("Race winner a horse: " + winner);
        return winner;
    }
}
