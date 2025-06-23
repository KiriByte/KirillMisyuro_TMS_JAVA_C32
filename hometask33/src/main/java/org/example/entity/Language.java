package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String name;

    @ManyToMany(mappedBy = "languages")
    public Set<Country> countries = new HashSet<>();

    public Language(String name) {
        this.name = name.toLowerCase();
    }

    public void addCountry(Country country) {
        countries.add(country);
        country.getLanguages().add(this);
    }

}
