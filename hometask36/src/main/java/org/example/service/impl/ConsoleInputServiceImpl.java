package org.example.service.impl;

import org.example.service.InputService;
import org.example.service.Logger;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleInputServiceImpl implements InputService {

    private final Logger logger;
    private Scanner scanner = new Scanner(System.in);

    public ConsoleInputServiceImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public int getHorseChoise(int maxHorses) {
        int choice;
        do {
            logger.log("Enter horse choice (1-" + maxHorses + "): ");
            choice = scanner.nextInt();
        }
        while (choice < 1 || choice > maxHorses);
        return choice;
    }

    @Override
    public int getBetAmount(int amount) {
        int bet;
        do {
            logger.log("Enter bet amount (1- " + amount + "): ");
            bet = scanner.nextInt();
        } while (bet < 1 || bet > amount);
        return bet;
    }

    @Override
    public boolean askContinue() {
        logger.log("Continue game& (y/n)");
        String answer = scanner.next();
        return answer.equalsIgnoreCase("y");
    }
}
