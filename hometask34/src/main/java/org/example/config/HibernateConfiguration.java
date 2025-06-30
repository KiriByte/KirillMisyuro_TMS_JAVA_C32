package org.example.config;

import org.example.entity.CarEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static org.example.config.ApplicationEnvironments.*;

public class HibernateConfiguration {

    public SessionFactory sessionFactory() {
        Configuration configuration = new Configuration();
        configuration
                .addAnnotatedClass(CarEntity.class)

                .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
                .setProperty("hibernate.connection.url", DB_URL)
                .setProperty("hibernate.connection.username", DB_USER)
                .setProperty("hibernate.connection.password", DB_PASSWORD)
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "create");

        return configuration.buildSessionFactory();
    }
}
