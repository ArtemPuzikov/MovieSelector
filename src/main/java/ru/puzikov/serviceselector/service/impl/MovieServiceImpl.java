package ru.puzikov.serviceselector.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.puzikov.serviceselector.domain.Movie;
import ru.puzikov.serviceselector.dto.MovieDto;
import ru.puzikov.serviceselector.repository.MovieRepository;
import ru.puzikov.serviceselector.service.MovieService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository; //так происходит инжект бина (Lombok @RequiredArgsConstructor) Лучший вариант, так как поле final позволяет сохранить класс неизменяемым


    public MovieDto getMovieById(Long id) {
        Movie movie = movieRepository.findMovieById(id);
        return MovieDto.builder()
                .name(movie.getName())
                .year(movie.getYear())
                .rate(movie.getYear())
                .genre(movie.getGenre())
                .description(movie.getDescription())
                .build();
    }

    public MovieDto getMovieByName(String name) {
        Movie movie = movieRepository.findMovieByName(name);
        return MovieDto.builder()
                .name(movie.getName())
                .year(movie.getYear())
                .rate(movie.getYear())
                .genre(movie.getGenre())
                .description(movie.getDescription())
                .build();
    }

    public MovieDto getMovie() {
        Random random = new Random();
        List<Movie> movies = movieRepository.findAll();
        int r = 0;
        while (r == 0) {
            r = random.nextInt(movies.size() + 1);
        }
        Movie movie = movieRepository.findMovieById((long) r);
        return MovieDto.builder()
                .name(movie.getName())
                .year(movie.getYear())
                .rate(movie.getYear())
                .genre(movie.getGenre())
                .description(movie.getDescription())
                .build();
    }

    public void save(MovieDto movieDto) {

        Movie movie = new Movie(movieDto.getName(),
                movieDto.getYear(),
                movieDto.getRate(),
                movieDto.getGenre(),
                movieDto.getDescription());

        movieRepository.save(movie);
    }

    public void update(MovieDto movieDto) {

        Movie movie = movieRepository.findMovieByName(movieDto.getName());
        movie.setYear(movieDto.getYear());
        movie.setRate(movieDto.getRate());
        movie.setGenre(movieDto.getGenre());
        movie.setDescription(movieDto.getDescription());

        movieRepository.save(movie);
    }

    public void deleteById(Long id) {
        Movie movie = movieRepository.findMovieById(id);
        movieRepository.delete(movie);
    }

    public void deleteByName(String name) {
        Movie movie = movieRepository.findMovieByName(name);
        movieRepository.delete(movie);
    }

    public List<MovieDto> getAll() {

        List<Movie> movies = movieRepository.findAll();
        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie movie : movies) {
            MovieDto movieDto = MovieDto.builder()
                    .name(movie.getName())
                    .year(movie.getYear())
                    .rate(movie.getRate())
                    .genre(movie.getGenre())
                    .description(movie.getDescription())
                    .build();

            movieDtos.add(movieDto);
        }

        return movieDtos;
    }

}
