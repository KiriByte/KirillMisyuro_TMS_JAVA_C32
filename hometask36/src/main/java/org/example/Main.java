package org.example;

import org.example.config.AppConfig;
import org.example.service.HippodromeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        HippodromeService hippodromeService = context.getBean(HippodromeService.class);
        hippodromeService.startGame();
    }
}