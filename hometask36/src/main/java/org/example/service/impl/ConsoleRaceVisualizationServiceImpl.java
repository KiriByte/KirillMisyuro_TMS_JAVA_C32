package org.example.service.impl;

import org.example.service.MessageOutput;
import org.example.service.RaceVisualizationService;
import org.springframework.stereotype.Service;

@Service
public class ConsoleRaceVisualizationServiceImpl implements RaceVisualizationService {

    private final MessageOutput messageOutput;

    public ConsoleRaceVisualizationServiceImpl(MessageOutput messageOutput) {
        this.messageOutput = messageOutput;
    }

    @Override
    public void visualizeRace(int[] positions, int raceLength) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < positions.length; i++) {
            builder.append("Horse ").append(i + 1).append(": ");
            for (int j = 0; j < raceLength; j++) {
                if (j < positions[i]) {
                    builder.append(">");
                } else if (j == positions[i]) {
                    builder.append("H");
                } else {
                    builder.append("-");
                }
            }
            builder.append("\n");
        }
        cleanLogger();
        messageOutput.write(builder.toString());
    }

    private void cleanLogger() {
        messageOutput.write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
