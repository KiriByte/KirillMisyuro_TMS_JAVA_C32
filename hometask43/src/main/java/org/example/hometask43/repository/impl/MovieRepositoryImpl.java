package org.example.hometask43.repository.impl;

import org.example.hometask43.entity.Movie;
import org.example.hometask43.repository.MovieRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private final List<Movie> movies;

    public MovieRepositoryImpl() {
        this.movies = new ArrayList<>();

    }

    @Override
    public Movie save(Movie movie) {
        movies.add(movie);
        return movie;
    }

    @Override
    public Optional<Movie> findById(UUID uuid) {

        return movies.stream()
                .filter(movie -> movie.getId().equals(uuid))
                .findFirst();
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(movies);
    }

    @Override
    public Movie update(Movie movie) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId().equals(movie.getId())) {
                return movies.set(i, movie);
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(UUID uuid) {
        return movies.removeIf(movie -> movie.getId().equals(uuid));
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equals(title))
                .toList();
    }
}
