package org.example.service.impl;

import org.example.config.HibernateConfiguration;
import org.example.entity.Order;
import org.example.service.OrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    private final SessionFactory sessionFactory;

    public OrderServiceImpl() {
        this.sessionFactory = new HibernateConfiguration().sessionFactory();
    }


    @Override
    public Order save(Order order) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(order);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    @Override
    public Optional<Order> findById(UUID id) {
        Session session = sessionFactory.openSession();
        Order order = session.find(Order.class, id);
        session.close();
        return Optional.ofNullable(order);
    }

    @Override
    public List<Order> findAll() {
        Session session = sessionFactory.openSession();
        List<Order> orders = session
                .createQuery("SELECT o FROM Order o", Order.class)
                .getResultList();
        session.close();
        return orders;
    }

    @Override
    public Order update(Order order) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(order);
        session.getTransaction().commit();
        session.close();
        return order;
    }

    @Override
    public void deleteById(UUID id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Order order = session.find(Order.class, id);
        session.remove(order);
        session.getTransaction().commit();
        session.close();
    }
}
