package org.example.hometask43.service;

import org.example.hometask43.dto.MovieDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieService {

    void saveMovie(MovieDto movieDto);

    List<MovieDto> getMovies();

    List<MovieDto> findMovieByTitle(String title);

    Optional<MovieDto> findMovieById(UUID id);

    boolean deleteMovieById(UUID id);

}
