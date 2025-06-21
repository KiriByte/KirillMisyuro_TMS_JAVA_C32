package org.example.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
@ToString
public class Address {
    private String street;
    private String city;
}
