package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "capitals")
public class Capital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ToString.Exclude
    @OneToOne(mappedBy = "capital")
    private Country country;

    public Capital(String name) {
        this.name = name;
    }

}
