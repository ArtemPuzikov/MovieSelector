package ru.puzikov.serviceselector.service.impl;

import org.springframework.stereotype.Service;
import ru.puzikov.serviceselector.domain.Movie;
import ru.puzikov.serviceselector.dto.MovieDto;
import ru.puzikov.serviceselector.service.MovieDtoService;

@Service
public class MovieDtoServiceImpl implements MovieDtoService {

    public MovieDto createMovieDto(Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getName(),
                movie.getYear(),
                movie.getRate(),
                movie.getGenre(),
                movie.getDescription());

    }
}
