package ru.puzikov.serviceselector.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.puzikov.serviceselector.domain.Movie;
import ru.puzikov.serviceselector.dto.MovieDto;
import ru.puzikov.serviceselector.dto.request.MovieRequest;
import ru.puzikov.serviceselector.dto.response.MovieResponse;
import ru.puzikov.serviceselector.repository.MovieRepository;
import ru.puzikov.serviceselector.service.MovieService;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository; //так происходит инжект бина (Lombok @RequiredArgsConstructor) Лучший вариант, так как поле final позволяет сохранить класс неизменяемым

    private final MovieDtoServiceImpl movieDtoService;

    public MovieDto getMovieById(Long id) {
        Movie movie = movieRepository.findMovieById(id);

        if (movie == null) {
            return null;
        }

        return movieDtoService.createMovieDto(movie);
    }

    public MovieDto getMovieByName(String name) {
        Movie movie = movieRepository.findMovieByName(name);

        if (movie == null) {
            return null;
        }

        return movieDtoService.createMovieDto(movie);
    }

    public MovieDto getMovie() {
        Random random = new Random();
        // take all exists movies
        List<Movie> movies = movieRepository.findAll();
        // take from other film it id and collect
        List<Long> allExistsId = movies.stream().map(
                movie -> movie.getId())
                .collect(Collectors.toList());

        int min = 0;
        int max = allExistsId.size();

        int randomId = min + random.nextInt(max);

        // make movie from random value of Ids collection
        Movie movie = movieRepository.findMovieById(allExistsId.get(randomId));

        return movieDtoService.createMovieDto(movie);
    }

    public MovieDto save(MovieRequest movieRequest) {

        Movie movie = new Movie(movieRequest.getName(),
                movieRequest.getYear(),
                movieRequest.getRate(),
                movieRequest.getGenre(),
                movieRequest.getDescription());

        movieRepository.save(movie);

        return movieDtoService.createMovieDto(movie);
    }

    public MovieDto update(MovieRequest movieRequest) {

        Movie movie = movieRepository.findMovieByName(movieRequest.getName());
        movie.setYear(movieRequest.getYear());
        movie.setRate(movieRequest.getRate());
        movie.setGenre(movieRequest.getGenre());
        movie.setDescription(movieRequest.getDescription());

        movieRepository.save(movie);

        return movieDtoService.createMovieDto(movie);
    }

    public MovieDto deleteById(Long id) {
        Movie movie = movieRepository.findMovieById(id);

        movieRepository.delete(movie);

        return movieDtoService.createMovieDto(movie);
    }

    public MovieDto deleteByName(String name) {
        Movie movie = movieRepository.findMovieByName(name);

        movieRepository.delete(movie);

        return movieDtoService.createMovieDto(movie);
    }

    public List<MovieDto> getAll() {
        List<Movie> movies = movieRepository.findAll();

        return movies.stream().map(
                movie -> movieDtoService.createMovieDto(movie))
                .collect(Collectors.toList());
    }

    public MovieResponse formMovieResponse(List<MovieDto> movieDto) {
        MovieResponse movieResponse = new MovieResponse();

        movieResponse.setMovies(movieDto);

        return movieResponse;
    }

}
