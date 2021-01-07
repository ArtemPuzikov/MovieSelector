package ru.puzikov.serviceselector.dto.response;

import lombok.AllArgsConstructor;
import ru.puzikov.serviceselector.dto.MovieDto;

import java.util.List;


@AllArgsConstructor
public class MovieResponse {
    List<MovieDto> movies;


    public List<MovieDto> getMovies() {
        return this.movies;
    }
}
