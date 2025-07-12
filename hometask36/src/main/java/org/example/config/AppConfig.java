package org.example.config;

import org.example.model.Player;
import org.example.service.*;
import org.example.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Player player() {
        return new Player();
    }

    @Bean
    public BetExecuterService betExecuterService(Player player, MessageOutput messageOutput) {
        return new BetExecuterServiceImpl(player, messageOutput);
    }

    @Bean
    public UserInput inputService(MessageOutput messageOutput) {
        return new ConsoleUserInputImpl(messageOutput);
    }

    @Bean
    public MessageOutput logger() {
        return new ConsoleMessageOutputImpl();
    }

    @Bean
    public RaceVisualizationService visualizationService(MessageOutput messageOutput) {
        return new ConsoleRaceVisualizationServiceImpl(messageOutput);
    }

    @Bean
    public HippodromeService hippodromeService(MessageOutput messageOutput, Player player, RoundService roundService) {
        return new HippodromeServiceImpl(messageOutput, player, roundService);
    }

    @Bean
    public RoundService roundService(MessageOutput messageOutput, Player player, HorseService horseService, UserInput userInput, BetExecuterService betExecuterService, RaceService raceService) {
        return new RoundServiceImpl(messageOutput, player, horseService, userInput, betExecuterService, raceService);
    }

    @Bean
    public HorseService horseService(MessageOutput messageOutput) {
        return new HorseServiceImpl(messageOutput);
    }

    @Bean
    public RaceService raceService(MessageOutput messageOutput, RaceVisualizationService visualizationService) {
        return new RaceServiceImpl(messageOutput, visualizationService);
    }

}
