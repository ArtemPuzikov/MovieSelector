package ru.puzikov.serviceselector.service;

import ru.puzikov.serviceselector.dto.MovieDto;

import java.util.List;

public interface MovieService {
    public MovieDto getMovieById(Long id);

    public MovieDto getMovie();

    public void save(MovieDto movieDto);

    void update(MovieDto movieDto);

    public void deleteById(Long id);

    public void deleteByName(String name);

    public List<MovieDto> getAll();
}
