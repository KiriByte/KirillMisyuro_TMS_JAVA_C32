package org.example.utils;

import org.example.entity.Brand;
import org.example.entity.CarEntity;

import java.util.Random;

public final class CarGenerator {

    private static final int MIN_PRICE = 5000;
    private static final int MAX_PRICE = 50000;
    private static final int MIN_YEAR = 1985;
    private static final int MAX_YEAR = 2025;
    private static final int MAX_MILEAGE = 100000;

    private static Random rand = new Random();

    private CarGenerator() {
    }

    public static CarEntity generateCar() {
        CarEntity car = CarEntity.builder()
                .brand(Brand.getRandom())
                .price(MIN_PRICE + rand.nextInt(MAX_PRICE - MIN_PRICE + 1))
                .mileage(rand.nextInt(MAX_MILEAGE))
                .year(MIN_YEAR + rand.nextInt(MAX_YEAR - MIN_YEAR + 1))
                .build();
        return car;
    }
}
