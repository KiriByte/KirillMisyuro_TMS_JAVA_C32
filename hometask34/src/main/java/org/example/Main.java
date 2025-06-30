package org.example;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.config.HibernateConfiguration;
import org.example.dto.SearchDto;
import org.example.entity.Brand;
import org.example.entity.CarEntity;
import org.example.service.SearchCarsService;
import org.example.utils.DbInitializer;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new HibernateConfiguration().sessionFactory();

        var dbInitializer = new DbInitializer(sessionFactory);
        dbInitializer.initialize();

        var searchDtoBuilder = SearchDto.builder();
        SearchDto searchDto = searchDtoBuilder
                .brand(Brand.AUDI)
                .maxYear(2010)
                .build();
        
        var searchService = new SearchCarsService(sessionFactory);
        List<CarEntity> carEntities = searchService.searchCars(searchDto);
        carEntities.forEach(System.out::println);

    }
}
