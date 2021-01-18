package ru.puzikov.serviceselector.service;

import ru.puzikov.serviceselector.domain.Movie;
import ru.puzikov.serviceselector.dto.MovieDto;
import ru.puzikov.serviceselector.dto.request.MovieRequest;

public interface MovieDtoService {

    MovieDto createMovieDto(Movie movie);

}
