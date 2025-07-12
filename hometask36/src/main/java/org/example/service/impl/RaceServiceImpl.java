package org.example.service.impl;

import org.example.service.MessageOutput;
import org.example.service.RaceService;
import org.example.service.RaceVisualizationService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RaceServiceImpl implements RaceService {

    private final MessageOutput messageOutput;
    private final RaceVisualizationService visualizationService;
    private final Random random = new Random();
    private final static int RACE_LENGTH = 50;

    public RaceServiceImpl(MessageOutput messageOutput,
                           RaceVisualizationService visualizationService) {
        this.messageOutput = messageOutput;
        this.visualizationService = visualizationService;
    }

    @Override
    public int getWinner(int horseCount) {
        messageOutput.write("Race start!");
        int winner = -1;
        int[] postitions = new int[horseCount];
        while (winner == -1) {

            for (int i = 0; i < horseCount; i++) {
                postitions[i] += random.nextInt(3) + 1;
                if (postitions[i] >= RACE_LENGTH) {
                    winner = i + 1;
                }
            }
            visualizationService.visualizeRace(postitions, RACE_LENGTH);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        messageOutput.write("Race finished! Winner horse " + winner);
        return winner;
    }


}
