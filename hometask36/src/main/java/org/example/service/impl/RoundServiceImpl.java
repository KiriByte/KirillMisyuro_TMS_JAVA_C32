package org.example.service.impl;

import org.example.model.Player;
import org.example.service.*;
import org.springframework.stereotype.Service;

@Service
public class RoundServiceImpl implements RoundService {

    private final MessageOutput messageOutput;
    private final Player player;
    private final HorseService horseService;
    private final UserInput userInput;
    private final BetExecuterService betExecuterService;
    private final RaceService raceService;

    public RoundServiceImpl(MessageOutput messageOutput,
                            Player player,
                            HorseService horseService,
                            UserInput userInput,
                            BetExecuterService betExecuterService,
                            RaceService raceService) {
        this.messageOutput = messageOutput;
        this.player = player;
        this.horseService = horseService;
        this.userInput = userInput;
        this.betExecuterService = betExecuterService;
        this.raceService = raceService;
    }

    @Override
    public void playRound() {
        messageOutput.write("============================================================");
        messageOutput.write("New Round");
        messageOutput.write("Your balance: " + player.getMoney());

        // Add set horses from console
        int horseCount = horseService.setHorseCount(3);
        horseService.displayHorses();

        int chosenHorse = userInput.getHorseChoise(horseCount);
        int betAmount = userInput.getBetAmount(player.getMoney());

        betExecuterService.placeBet(betAmount);

        int winner = raceService.getWinner(horseCount);

        if (chosenHorse == winner) {
            messageOutput.write("Congratulations! You win!");
            betExecuterService.payoutWin(betAmount * 2);
        } else {
            messageOutput.write("Sorry, you lost!");
        }
        messageOutput.write("Your balance: " + player.getMoney());
    }
}

