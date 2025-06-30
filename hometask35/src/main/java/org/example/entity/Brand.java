package org.example.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public enum Brand {
    VOLKSWAGEN,
    CITROEN,
    HONDA,
    AUDI,
    BMW,
    GEELY,
    HYUNDAI,
    PEUGEOT,
    FORD,
    NISSAN,
    KIA,
    TOYOTA;

    public static Brand getRandom() {
        List<Brand> brands = Arrays.asList(Brand.values());
        return brands.get(new Random().nextInt(brands.size()));
    }
}
