package com.kiribyte.fastfood.services.interfaces;

import com.kiribyte.fastfood.models.Order;

public interface IFastFoodService {

    void handleOrder(String customerName, String deliveryAddress);
}
