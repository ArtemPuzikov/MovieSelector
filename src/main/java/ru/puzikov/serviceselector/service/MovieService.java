package ru.puzikov.serviceselector.service;

import ru.puzikov.serviceselector.dto.MovieDto;
import ru.puzikov.serviceselector.dto.request.MovieRequest;
import ru.puzikov.serviceselector.dto.response.MovieResponse;

import java.util.List;

public interface MovieService {

    MovieDto getMovieById(Long id);

    MovieDto getMovie();

    MovieDto save(MovieRequest movieRequest);

    MovieDto update(MovieRequest movieRequest);

    MovieDto deleteById(Long id);

    MovieDto deleteByName(String name);

    List<MovieDto> getAll();
}
