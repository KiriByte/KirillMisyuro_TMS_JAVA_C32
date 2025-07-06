package org.example.service.impl;

import org.example.model.Player;
import org.example.service.*;
import org.springframework.stereotype.Service;

@Service
public class HippodromeServiceImpl implements HippodromeService {

    private final Logger logger;
    private final Player player;
    private final InputService inputService;
    private final HorseService horseService;
    private final BetExecuterService betExecuterService;
    private final RaceService raceService;

    public HippodromeServiceImpl(Logger logger,
                                 Player player,
                                 InputService inputService,
                                 HorseService horseService,
                                 BetExecuterService betExecuterService,
                                 RaceService raceService) {
        this.logger = logger;
        this.player = player;
        this.inputService = inputService;
        this.horseService = horseService;
        this.betExecuterService = betExecuterService;
        this.raceService = raceService;
    }

    @Override
    public void startGame() {
        logger.log("Starting Game");
        logger.log("Your balance: " + player.getMoney());

        while (player.getMoney() > 0) {
            playRound();

            if (player.getMoney() > 0 && !inputService.askContinue()) {
                break;
            }
        }
        if (player.getMoney() <= 0) {
            logger.log("Game over");
            System.exit(0);
        }
    }

    private void playRound() {
        logger.log("New Round");
        logger.log("Your balance: " + player.getMoney());

        // Add set horses from console
        int horseCount = horseService.setHorseCount(3);
        horseService.displayHorses();

        int chosenHorse = inputService.getHorseChoise(horseCount);
        int betAmount = inputService.getBetAmount(player.getMoney());

        betExecuterService.getMoneyForBet(betAmount);

        //Add dynamic race
        int winner = raceService.startRace(horseCount);

        if (chosenHorse == winner) {
            logger.log("Congratulations! You win!");
            betExecuterService.executeBet(betAmount * 2);
        } else {
            logger.log("Sorry, you lost!");
        }
        logger.log("Your balance: " + player.getMoney());
    }
}
