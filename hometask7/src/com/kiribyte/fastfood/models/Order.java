package com.kiribyte.fastfood.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Order {
    private String id;
    private LocalDateTime orderTime;
    private OrderStatus status;
    private String customerName;
    private String deliveryAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Order(String customerName, String deliveryAddress) {
        this.id = UUID.randomUUID().toString();
        this.orderTime = LocalDateTime.now();
        this.status = OrderStatus.CREATED;
        this.customerName = customerName;
        this.deliveryAddress = deliveryAddress;

    }
}
