package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Order {

    private UUID id;
    private String name;
    private OrderStatus status;

    public Order(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.status = OrderStatus.CREATED;
    }
}


