package org.example.hometask43.mapper;

import org.example.hometask43.dto.MovieDto;
import org.example.hometask43.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    MovieDto movieToMovieDto(Movie movie);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    Movie movieDtoToMovie(MovieDto movieDto);
}
