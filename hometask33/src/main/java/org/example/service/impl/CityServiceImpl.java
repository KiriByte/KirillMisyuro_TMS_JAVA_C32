package org.example.service.impl;

import org.example.config.HibernateConfiguration;
import org.example.entity.Capital;
import org.example.entity.City;
import org.example.entity.Country;
import org.example.service.CityService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class CityServiceImpl implements CityService {
    private final SessionFactory sessionFactory;

    public CityServiceImpl() {
        this.sessionFactory = new HibernateConfiguration().sessionFactory();
    }

    @Override
    public City save(City city) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(city);
        session.getTransaction().commit();
        session.close();
        return city;
    }

    @Override
    public Optional<City> findById(Integer id) {
        Session session = sessionFactory.openSession();
        City city = session.get(City.class, id);
        session.close();
        return Optional.ofNullable(city);
    }

    @Override
    public List<City> findAll() {
        Session session = sessionFactory.openSession();
        List<City> cities = session
                .createQuery("SELECT c from City c", City.class)
                .getResultList();
        session.close();
        return cities;
    }

    @Override
    public City update(City city) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(city);
        session.getTransaction().commit();
        session.close();
        return city;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        City city = session.find(City.class, id);
        session.remove(city);
        session.getTransaction().commit();
        session.close();
    }
}
