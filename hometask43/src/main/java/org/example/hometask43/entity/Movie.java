package org.example.hometask43.entity;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private UUID id;
    private String title;
    private String description;

    public Movie(String title, String description) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
    }
}
