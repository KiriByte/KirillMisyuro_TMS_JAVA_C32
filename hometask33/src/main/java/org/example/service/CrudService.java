package org.example.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    T save(T t);

    Optional<T> findById(ID id);

    List<T> findAll();

    public T update(T t);

    public void deleteById(ID id);
}
