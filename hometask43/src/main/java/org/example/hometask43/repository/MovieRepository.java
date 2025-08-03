package org.example.hometask43.repository;

import org.example.hometask43.entity.Movie;

import java.util.List;
import java.util.UUID;

public interface MovieRepository extends CrudRepository<Movie, UUID> {

    List<Movie> findByTitle(String title);
}
