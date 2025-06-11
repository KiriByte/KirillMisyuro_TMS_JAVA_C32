package org.example;

import org.example.model.Order;

import java.util.HashSet;
import java.util.Set;

public class Task2 {

    public void run() {
        var order1 = new Order("name1");
        var order2 = new Order("name2");
        var order3 = new Order("name3");

        Set<Order> orders = new HashSet<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        //dublicated
        var order4 = order1;
        order4.setName("name4");
        orders.add(order4);

        //add new
        var order5 = new Order(order2.getId(), "name5", order2.getStatus());
        orders.add(order5);

        //ignoring. not adding
        var order6 = new Order(order3.getId(), "name3", order3.getStatus());
        orders.add(order6);

        for (var order : orders) {
            System.out.println(order);
        }
    }
}
