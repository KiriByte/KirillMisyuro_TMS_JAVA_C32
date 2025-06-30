package org.example.utils;

import org.example.config.HibernateConfiguration;
import org.example.entity.CarEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DbInitializer {
    private SessionFactory sessionFactory;

    public DbInitializer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void initialize() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            for (int i = 0; i < 50; i++) {
                CarEntity car = CarGenerator.generateCar();
                session.persist(car);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
