package com.kiribyte.fastfood.services.impl;

import com.kiribyte.fastfood.models.Order;
import com.kiribyte.fastfood.services.interfaces.ILoggerService;
import com.kiribyte.fastfood.services.interfaces.IOrderStorage;

public class StorageOrderImpl implements IOrderStorage {

    private ILoggerService logger;

    public StorageOrderImpl(ILoggerService logger) {
        this.logger = logger;
    }

    @Override
    public void addOrder(Order order) {
        logger.log(order.getId() + " Adding order to DB");
    }
}
