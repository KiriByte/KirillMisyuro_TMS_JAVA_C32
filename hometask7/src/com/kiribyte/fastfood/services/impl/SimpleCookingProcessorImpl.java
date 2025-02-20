package com.kiribyte.fastfood.services.impl;

import com.kiribyte.fastfood.models.Order;
import com.kiribyte.fastfood.models.OrderStatus;
import com.kiribyte.fastfood.services.interfaces.ICookingProcessor;
import com.kiribyte.fastfood.services.interfaces.ILoggerService;

public class SimpleCookingProcessorImpl implements ICookingProcessor {

    private ILoggerService logger;

    public SimpleCookingProcessorImpl(ILoggerService logger) {
        this.logger = logger;
    }

    @Override
    public void cook(Order order) {
        order.setStatus(OrderStatus.COOKING);
        logger.log(order.getId() + " Cooking order");
        logger.logOrderStatus(order);
    }
}
