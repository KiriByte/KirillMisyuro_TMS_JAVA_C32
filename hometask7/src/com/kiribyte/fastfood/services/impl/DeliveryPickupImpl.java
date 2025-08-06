package com.kiribyte.fastfood.services.impl;

import com.kiribyte.fastfood.models.Order;
import com.kiribyte.fastfood.models.OrderStatus;
import com.kiribyte.fastfood.services.interfaces.ILoggerService;
import com.kiribyte.fastfood.services.interfaces.IOrderDelivery;

public class DeliveryPickupImpl implements IOrderDelivery {

    private ILoggerService logger;

    public DeliveryPickupImpl(ILoggerService logger) {
        this.logger = logger;
    }

    @Override
    public void confirmDelivery(Order order) {
        logger.log(order.getId() + " The customer picked up order");
        order.setStatus(OrderStatus.COMPLETED);
        logger.logOrderStatus(order);
    }
}
