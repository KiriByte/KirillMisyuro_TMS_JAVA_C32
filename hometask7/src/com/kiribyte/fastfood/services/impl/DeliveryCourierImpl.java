package com.kiribyte.fastfood.services.impl;

import com.kiribyte.fastfood.models.Order;
import com.kiribyte.fastfood.models.OrderStatus;
import com.kiribyte.fastfood.services.interfaces.ILoggerService;
import com.kiribyte.fastfood.services.interfaces.IOrderDelivery;

public class DeliveryCourierImpl implements IOrderDelivery {

    private ILoggerService logger;

    public DeliveryCourierImpl(ILoggerService logger) {
        this.logger = logger;
    }

    @Override
    public void pickupOrder(Order order) {
        order.setStatus(OrderStatus.READY);
        logger.logOrderStatus(order);
        logger.log(order.getId() + " The courier picked up order");
        order.setStatus(OrderStatus.DELIVERYING);
        logger.logOrderStatus(order);
    }

    @Override
    public void confirmDelivery(Order order) {
        order.setStatus(OrderStatus.COMPLETED);
        logger.log(order.getId() + " Order was delivered");
        logger.logOrderStatus(order);
    }
}
