package org.example;

import org.example.entity.Address;
import org.example.entity.Order;
import org.example.entity.ProductType;
import org.example.service.OrderService;
import org.example.service.impl.OrderServiceImpl;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        OrderService orderService = new OrderServiceImpl();
        Address address = new Address("Sovetskaya", "Hrodna");

        Order order = Order.builder()
                .name("Book1")
                .product(ProductType.BOOKS)
                .orderDate(Instant.now())
                .address(address)
                .cost(500L)
                .isPriorityOrder(false)
                .build();

        Order save = orderService.save(order);

        Optional<Order> findOrder = orderService.findById(save.getId());

        if (findOrder.isPresent()) {
            System.out.println(findOrder.toString());
        }

    }
}
