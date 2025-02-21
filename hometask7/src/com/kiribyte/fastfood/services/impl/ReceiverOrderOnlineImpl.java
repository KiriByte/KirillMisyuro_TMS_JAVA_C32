package com.kiribyte.fastfood.services.impl;

import com.kiribyte.fastfood.models.Order;
import com.kiribyte.fastfood.services.interfaces.ILoggerService;
import com.kiribyte.fastfood.services.interfaces.IOrderReceiver;

public class ReceiverOrderOnlineImpl implements IOrderReceiver {

    private ILoggerService logger;

    public ReceiverOrderOnlineImpl(ILoggerService logger) {
        this.logger = logger;
    }

    @Override
    public Order receiveOrder(String customerName, String deliveryAddress) {
        Order order = new Order(customerName, deliveryAddress);
        logger.log(order.getId() + " Order received by online");
        logger.logOrderStatus(order);
        return order;
    }
}
