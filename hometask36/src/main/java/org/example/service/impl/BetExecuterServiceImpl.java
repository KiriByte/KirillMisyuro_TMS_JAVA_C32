package org.example.service.impl;

import org.example.model.Player;
import org.example.service.BetExecuterService;
import org.example.service.Logger;
import org.springframework.stereotype.Service;

@Service
public class BetExecuterServiceImpl implements BetExecuterService {

    private final Player player;
    private final Logger logger;

    public BetExecuterServiceImpl(Player player, Logger logger) {
        this.player = player;
        this.logger = logger;
    }

    @Override
    public void executeBet(int money) {
        player.addMoney(money);
        logger.log("Player received " + money + "money");
    }

    @Override
    public void getMoneyForBet(int money) {
        player.decreaseMoney(money);
        logger.log("Player decreased " + money + "money");
    }
}
