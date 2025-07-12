package org.example.service.impl;

import org.example.model.Player;
import org.example.service.BetExecuterService;
import org.example.service.MessageOutput;
import org.springframework.stereotype.Service;

@Service
public class BetExecuterServiceImpl implements BetExecuterService {

    private final Player player;
    private final MessageOutput messageOutput;

    public BetExecuterServiceImpl(Player player, MessageOutput messageOutput) {
        this.player = player;
        this.messageOutput = messageOutput;
    }

    @Override
    public void payoutWin(int money) {
        player.addMoney(money);
        messageOutput.write("Player received " + money + "money");
    }

    @Override
    public void placeBet(int money) {
        player.decreaseMoney(money);
        messageOutput.write("Player decreased " + money + "money");
    }
}
