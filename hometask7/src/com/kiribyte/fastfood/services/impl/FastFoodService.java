package com.kiribyte.fastfood.services.impl;

import com.kiribyte.fastfood.models.Order;
import com.kiribyte.fastfood.models.OrderStatus;
import com.kiribyte.fastfood.services.interfaces.*;

public class FastFoodService implements IFastFoodService {

    private ICookingProcessor cookingProcessor;
    private IOrderDelivery orderDelivery;
    private IOrderReceiver orderReceiver;
    private IOrderStorage orderStorage;

    public FastFoodService(IOrderReceiver orderReceiver,
                           IOrderStorage orderStorage,
                           ICookingProcessor cookingProcessor,
                           IOrderDelivery orderDelivery) {
        this.orderReceiver = orderReceiver;
        this.orderStorage = orderStorage;
        this.cookingProcessor = cookingProcessor;
        this.orderDelivery = orderDelivery;


    }


    @Override
    public void handleOrder(String customerName, String deliveryAddress) {
        Order order = orderReceiver.receiveOrder(customerName, deliveryAddress);
        orderStorage.addOrder(order);
        cookingProcessor.cook(order);
        orderDelivery.pickupOrder(order);
        orderDelivery.confirmDelivery(order);
    }
}
