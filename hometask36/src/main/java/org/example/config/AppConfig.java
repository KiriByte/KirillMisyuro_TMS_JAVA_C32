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
    public BetExecuterService betExecuterService() {
        return new BetExecuterServiceImpl(player(), logger());
    }

    @Bean
    public InputService inputService() {
        return new ConsoleInputServiceImpl(logger());
    }

    @Bean
    public Logger logger() {
        return new ConsoleLoggerImpl();
    }

    @Bean
    public RaceVisualizationService visualizationService() {
        return new ConsoleRaceVisualizationServiceImpl(logger());
    }

    @Bean
    public HippodromeService gameService() {
        return new HippodromeServiceImpl(logger(), player(), inputService(), horseService(), betExecuterService(), raceService());
    }

    @Bean
    public HorseService horseService() {
        return new HorseServiceImpl(logger());
    }

    @Bean
    public RaceService raceService() {
        return new RaceServiceImpl(logger(), visualizationService());
    }


}
