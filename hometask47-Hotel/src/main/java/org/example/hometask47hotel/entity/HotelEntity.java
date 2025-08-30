package org.example.hometask47hotel.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "hotels")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private boolean isAvailable;
}
