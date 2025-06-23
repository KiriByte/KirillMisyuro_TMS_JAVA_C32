package org.example.service.impl;

import org.example.config.HibernateConfiguration;
import org.example.entity.Capital;
import org.example.entity.Country;
import org.example.service.CapitalService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class CapitalServiceImpl implements CapitalService {

    private final SessionFactory sessionFactory;

    public CapitalServiceImpl() {
        this.sessionFactory = new HibernateConfiguration().sessionFactory();
    }

    @Override
    public Capital save(Capital capital) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(capital);
        session.getTransaction().commit();
        session.close();
        return capital;
    }

    @Override
    public Optional<Capital> findById(Integer id) {
        Session session = sessionFactory.openSession();
        Capital capital = session.get(Capital.class, id);
        session.close();
        return Optional.ofNullable(capital);
    }

    @Override
    public List<Capital> findAll() {
        Session session = sessionFactory.openSession();
        List<Capital> capitals = session
                .createQuery("SELECT c from Capital c", Capital.class)
                .getResultList();
        session.close();
        return capitals;
    }

    @Override
    public Capital update(Capital capital) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(capital);
        session.getTransaction().commit();
        session.close();
        return capital;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Capital capital = session.find(Capital.class, id);
        session.remove(capital);
        session.getTransaction().commit();
        session.close();
    }
}
