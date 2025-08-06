package org.example.hometask43.repository.impl;

import org.example.hometask43.entity.Movie;
import org.example.hometask43.repository.MovieRepository;
import org.example.hometask43.service.FileStorageService;
import org.example.hometask43.service.SerializationService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private final List<Movie> movies;
    private final FileStorageService fileStorageService;
    private final SerializationService<Movie> serializationService;
    private static final String STORAGE_FILE = "movies.json";

    public MovieRepositoryImpl(
            FileStorageService fileStorageService,
            SerializationService<Movie> serializationService) {
        this.fileStorageService = fileStorageService;
        this.serializationService = serializationService;
        this.movies = loadMovies();
    }

    private List<Movie> loadMovies() {
        Optional<String> optionalString = fileStorageService.readFromFile(STORAGE_FILE);
        if (optionalString.isPresent()) {
            String data = optionalString.get();
            return serializationService.deserialize(data, Movie.class);
        }
        return new ArrayList<>();
    }

    private void saveMovies() {
        String data = serializationService.serialize(movies);
        fileStorageService.saveToFile(STORAGE_FILE, data);
    }

    @Override
    public Movie save(Movie movie) {
        movies.add(movie);
        saveMovies();
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
                var result = movies.set(i, movie);
                if (result != null) {
                    saveMovies();
                }
                return movie;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(UUID uuid) {
        var result = movies.removeIf(movie -> movie.getId().equals(uuid));
        if (result) {
            saveMovies();
        }
        return result;
    }

    @Override
    public List<Movie> findByTitle(String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equals(title))
                .toList();
    }
}
