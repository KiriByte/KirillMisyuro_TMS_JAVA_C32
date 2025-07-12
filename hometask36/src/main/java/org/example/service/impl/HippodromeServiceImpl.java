package org.example.service.impl;

import org.example.model.Player;
import org.example.service.*;
import org.springframework.stereotype.Service;

@Service
public class HippodromeServiceImpl implements HippodromeService {

    private final MessageOutput messageOutput;
    private final Player player;
    private final RoundService roundService;

    public HippodromeServiceImpl(MessageOutput messageOutput,
                                 Player player,
                                 RoundService roundService) {
        this.messageOutput = messageOutput;
        this.player = player;
        this.roundService = roundService;
    }

    @Override
    public void startGame() {
        messageOutput.write("Starting Game");
        messageOutput.write("Your balance: " + player.getMoney());

        while (player.getMoney() > 0) {
            roundService.playRound();

        }
        if (player.getMoney() <= 0) {
            messageOutput.write("Game over");
        }
    }

}
