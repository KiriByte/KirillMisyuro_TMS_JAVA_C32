package org.example.model;

import org.springframework.stereotype.Component;

@Component
public class Player {
    private int money = 5000;

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void decreaseMoney(int money) {
        this.money -= money;
    }
}
