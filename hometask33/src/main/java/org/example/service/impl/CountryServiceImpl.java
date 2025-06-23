package org.example.service.impl;

import org.example.config.HibernateConfiguration;
import org.example.entity.Country;
import org.example.service.CountryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class CountryServiceImpl implements CountryService {

    private final SessionFactory sessionFactory;

    public CountryServiceImpl() {
        this.sessionFactory = new HibernateConfiguration().sessionFactory();
    }

    @Override
    public Country save(Country country) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //session.persist(country.getCapital());
        //session.persist(country.getCities());
        session.persist(country);
        session.getTransaction().commit();
        session.close();
        return country;
    }

    @Override
    public Optional<Country> findById(Integer id) {
        Session session = sessionFactory.openSession();
        Country country = session.get(Country.class, id);
        session.close();
        return Optional.ofNullable(country);
    }

    @Override
    public List<Country> findAll() {
        Session session = sessionFactory.openSession();
        List<Country> countries = session
                .createQuery("SELECT c from Country c", Country.class)
                .getResultList();
        session.close();
        return countries;
    }

    @Override
    public Country update(Country country) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(country);
        session.getTransaction().commit();
        session.close();
        return country;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Country country = session.find(Country.class, id);
        session.remove(country);
        session.getTransaction().commit();
        session.close();
    }
}
