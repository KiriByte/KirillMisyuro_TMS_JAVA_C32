package com.kiribyte.fastfood.services.impl;

import com.kiribyte.fastfood.models.Order;
import com.kiribyte.fastfood.services.interfaces.ILoggerService;
import com.kiribyte.fastfood.services.interfaces.IOrderReceiver;

public class ReceiverOrderPhoneImpl implements IOrderReceiver {

    private ILoggerService logger;

    public ReceiverOrderPhoneImpl(ILoggerService logger) {
        this.logger = logger;
    }

    @Override
    public Order receiveOrder(String customerName, String deliveryAddress) {
        Order order = new Order(customerName, deliveryAddress);
        logger.log(order.getId() + " Order received by phone");
        logger.logOrderStatus(order);
        return order;
    }
}
