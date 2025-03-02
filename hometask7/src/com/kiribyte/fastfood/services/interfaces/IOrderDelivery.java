package com.kiribyte.fastfood.services.interfaces;

import com.kiribyte.fastfood.models.Order;
import com.kiribyte.fastfood.models.OrderStatus;
import com.kiribyte.fastfood.utils.DateTimeUtils;


public interface IOrderDelivery {

    default void pickupOrder(Order order) {
        order.setStatus(OrderStatus.READY);
        System.out.println(DateTimeUtils.getCurrentDateTime() + " " + order.getId() + " Order is ready for pickup");
    }

    void confirmDelivery(Order order);
}
