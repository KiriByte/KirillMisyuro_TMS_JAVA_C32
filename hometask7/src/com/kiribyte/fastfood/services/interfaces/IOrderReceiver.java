package com.kiribyte.fastfood.services.interfaces;

import com.kiribyte.fastfood.models.Order;

public interface IOrderReceiver {

    Order receiveOrder(String customerName, String deliveryAddress);
}
