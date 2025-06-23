package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //OneToOne
    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "capital_id")
    private Capital capital;

    //OneToMany
    @ToString.Exclude
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<City> cities = new ArrayList<>();

    //ManyToMany
    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "country_languages",
            joinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "language_id", referencedColumnName = "id")
    )
    private Set<Language> languages = new HashSet<>();

    //-------------------------------------------------------------------------------------

    public Country(String name) {
        this.name = name;
    }

    public void addCity(City city) {
        cities.add(city);
        city.setCountry(this);
    }

    public void addLanguage(Language language) {
        languages.add(language);
        language.addCountry(this);
    }
}
