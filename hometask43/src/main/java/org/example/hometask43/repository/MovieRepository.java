package org.example.hometask43.repository;

import org.example.hometask43.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID> {
    List<Movie> findByTitle(String title);
}
