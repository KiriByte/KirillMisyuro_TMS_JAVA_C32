package org.example.service.impl;

import org.example.config.HibernateConfiguration;
import org.example.entity.Country;
import org.example.entity.Language;
import org.example.service.LanguageService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class LanguageServiceImpl implements LanguageService {

    private final SessionFactory sessionFactory;

    public LanguageServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = new HibernateConfiguration().sessionFactory();
    }

    @Override
    public Language save(Language language) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(language);
        session.getTransaction().commit();
        session.close();
        return language;
    }

    @Override
    public Optional<Language> findById(Integer id) {
        Session session = sessionFactory.openSession();
        Language language = session.get(Language.class, id);
        session.close();
        return Optional.ofNullable(language);
    }

    @Override
    public List<Language> findAll() {
        Session session = sessionFactory.openSession();
        List<Language> languages = session
                .createQuery("SELECT l from Language l", Language.class)
                .getResultList();
        session.close();
        return languages;
    }

    @Override
    public Language update(Language language) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(language);
        session.getTransaction().commit();
        session.close();
        return language;
    }

    @Override
    public void deleteById(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Language language = session.find(Language.class, id);
        session.remove(language);
        session.getTransaction().commit();
        session.close();
    }
}
