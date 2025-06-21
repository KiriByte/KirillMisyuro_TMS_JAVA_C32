package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "orders")
@ToString
public class Order {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 1024)
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductType product;
    @Column(name = "order_date")
    private Instant orderDate;
    @Embedded
    private Address address;
    @Column(nullable = false)
    private Long cost;
    @Column(name = "is_priority")
    private Boolean isPriorityOrder;
}
