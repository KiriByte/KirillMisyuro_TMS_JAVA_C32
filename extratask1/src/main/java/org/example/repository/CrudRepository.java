package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    T create(T entity);

    Optional<T> findById(int id);

    List<T> findAll();

    int update(T entity);

    void delete(int id);
    
}
