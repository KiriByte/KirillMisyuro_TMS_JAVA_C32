package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.dto.SearchDto;
import org.example.entity.CarEntity;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.JpaPredicate;

import java.util.ArrayList;
import java.util.List;

public class SearchCarsService {

    private SessionFactory sessionFactory;

    public SearchCarsService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<CarEntity> searchCars(SearchDto searchDto) {

        var session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CarEntity> query = builder.createQuery(CarEntity.class);
        Root<CarEntity> car = query.from(CarEntity.class);
        List<Predicate> predicates = new ArrayList<>();

        //equeal - ==
        //notequeal - !=
        //gt - greater than
        //ge - greater than or equal
        //lt - less than
        //le - less than or equal
        //between

        if (searchDto.getBrand() != null) {
            Predicate brandEq = builder.equal(car.get("brand"), searchDto.getBrand());
            predicates.add(brandEq);
        }
        if (searchDto.getMinPrice() != null) {
            Predicate minPriceEq = builder.ge(car.get("price"), searchDto.getMinPrice());
            predicates.add(minPriceEq);
        }
        if (searchDto.getMaxPrice() != null) {
            Predicate maxPriceEq = builder.le(car.get("price"), searchDto.getMaxPrice());
            predicates.add(maxPriceEq);
        }
        if (searchDto.getMinMileage() != null) {
            Predicate minMilleageEq = builder.ge(car.get("mileage"), searchDto.getMinMileage());
            predicates.add(minMilleageEq);
        }
        if (searchDto.getMaxMileage() != null) {
            Predicate maxMilleageEq = builder.le(car.get("mileage"), searchDto.getMaxMileage());
            predicates.add(maxMilleageEq);
        }
        if (searchDto.getMinYear() != null) {
            Predicate minYearEq = builder.ge(car.get("year"), searchDto.getMinYear());
            predicates.add(minYearEq);
        }
        if (searchDto.getMaxYear() != null) {
            Predicate maxYearEq = builder.le(car.get("year"), searchDto.getMaxYear());
            predicates.add(maxYearEq);
        }

        if (!predicates.isEmpty()) {
            query.where(predicates.toArray(new Predicate[0]));
        }

        var results = session.createQuery(query).list();

        session.getTransaction().commit();
        session.close();
        return results;
    }
}
