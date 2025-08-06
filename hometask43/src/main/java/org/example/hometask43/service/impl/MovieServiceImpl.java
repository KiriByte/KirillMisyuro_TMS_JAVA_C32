package org.example.hometask43.service.impl;

import org.example.hometask43.dto.MovieDto;
import org.example.hometask43.entity.Movie;
import org.example.hometask43.mapper.MovieMapper;
import org.example.hometask43.repository.MovieRepository;
import org.example.hometask43.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieServiceImpl(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public void saveMovie(MovieDto movieDto) {
        if (movieDto.getId() == null) {
            movieDto.setId(UUID.randomUUID());
        }
        Movie movie = movieMapper.movieDtoToMovie(movieDto);
        movieRepository.save(movie);
    }

    @Override
    public List<MovieDto> getMovies() {
        List<Movie> allMovies = movieRepository.findAll();
        List<MovieDto> movieDtos = new ArrayList<>();
        for (Movie movie : allMovies) {
            movieDtos.add(movieMapper.movieToMovieDto(movie));
        }
        return movieDtos;
    }

    @Override
    public List<MovieDto> findMovieByTitle(String title) {
        List<Movie> allMovies = movieRepository.findByTitle(title);
        List<MovieDto> movieDtos = new ArrayList<>();
        for (Movie movie : allMovies) {
            movieDtos.add(movieMapper.movieToMovieDto(movie));
        }
        return movieDtos;
    }

    @Override
    public Optional<MovieDto> findMovieById(UUID id) {
        Optional<Movie> byId = movieRepository.findById(id);
        if (byId.isPresent()) {
            return Optional.of(movieMapper.movieToMovieDto(byId.get()));
        }
        return Optional.empty();

    }

    @Override
    public boolean deleteMovieById(UUID id) {
        return movieRepository.deleteById(id);
    }
}
