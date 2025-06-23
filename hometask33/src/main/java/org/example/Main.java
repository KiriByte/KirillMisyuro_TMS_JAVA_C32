package org.example;

import org.example.config.HibernateConfiguration;
import org.example.entity.Capital;
import org.example.entity.City;
import org.example.entity.Country;
import org.example.entity.Language;
import org.example.service.CountryService;
import org.example.service.impl.CountryServiceImpl;
import org.hibernate.Session;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Capital capital = new Capital("Minsk");

        City hrodna = new City("Hrodna");
        City brest = new City("Brest");
        City gomel = new City("Gomel");

        Language english = new Language("English");
        Language russian = new Language("Russian");

        Country belarus = new Country("Belarus");
        belarus.setCapital(capital);
        belarus.addCity(hrodna);
        belarus.addCity(brest);
        belarus.addCity(gomel);
        belarus.addLanguage(english);
        belarus.addLanguage(russian);


        CountryService service = new CountryServiceImpl();
        Country save = service.save(belarus);

        Optional<Country> byId = service.findById(save.getId());
        if (byId.isPresent()) {
            System.out.println(byId.get().toString());
        }
    }
}