package org.example.hometask43.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {
    T save(T t);

    Optional<T> findById(ID id);

    List<T> findAll();

    T update(T t);

    boolean deleteById(ID id);
}
