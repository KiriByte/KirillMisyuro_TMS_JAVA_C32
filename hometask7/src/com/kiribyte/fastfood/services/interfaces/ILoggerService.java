package com.kiribyte.fastfood.services.interfaces;

import com.kiribyte.fastfood.models.Order;

public interface ILoggerService {

    void log(String message);
    void logOrderStatus(Order order);
}
