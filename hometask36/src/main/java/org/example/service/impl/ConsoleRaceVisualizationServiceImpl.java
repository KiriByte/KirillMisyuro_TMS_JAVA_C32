package org.example.service.impl;

import org.apache.commons.logging.Log;
import org.example.service.Logger;
import org.example.service.RaceVisualizationService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class ConsoleRaceVisualizationServiceImpl implements RaceVisualizationService {

    private final Logger logger;
    private int winner = -1;
    private final Random random = new Random();
    private final static int RACE_LENGTH = 50;


    public ConsoleRaceVisualizationServiceImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void visualizeRace(int horseCount) {

        int[] postitions = new int[horseCount];
        while (winner == -1) {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < horseCount; i++) {
                postitions[i] += random.nextInt(3) + 1;
                if (postitions[i] >= RACE_LENGTH) {
                    winner = i + 1;
                }
            }

            builder.append("\n");
            for (int i = 0; i < horseCount; i++) {
                builder.append("Horse " + (i + 1) + ": ");
                for (int j = 0; j < RACE_LENGTH; j++) {
                    if (j < postitions[i]) {
                        builder.append(">");
                    } else if (j == postitions[i]) {
                        builder.append("H");
                    } else {
                        builder.append("-");
                    }
                }
                builder.append("\n");
            }

            cleanLogger();
            logger.log(builder.toString());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


        }
        logger.log("Race finished! Winner horse" + winner);
    }

    @Override
    public int getWinner() {
        return winner;
    }

    private void setWinner(int winner) {
        this.winner = winner;
    }

    private void cleanLogger() {
        logger.log("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
