package org.example.service.impl;

import org.example.service.UserInput;
import org.example.service.MessageOutput;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleUserInputImpl implements UserInput {

    private final MessageOutput messageOutput;
    private Scanner scanner = new Scanner(System.in);

    public ConsoleUserInputImpl(MessageOutput messageOutput) {
        this.messageOutput = messageOutput;
    }

    @Override
    public int getHorseChoise(int maxHorses) {
        int choice;
        do {
            messageOutput.write("Enter horse choice (1-" + maxHorses + "): ");
            choice = scanner.nextInt();
        }
        while (choice < 1 || choice > maxHorses);
        return choice;
    }

    @Override
    public int getBetAmount(int amount) {
        int bet;
        do {
            messageOutput.write("Enter bet amount (1- " + amount + "): ");
            bet = scanner.nextInt();
        } while (bet < 1 || bet > amount);
        return bet;
    }

}
