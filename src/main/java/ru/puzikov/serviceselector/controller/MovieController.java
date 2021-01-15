package ru.puzikov.serviceselector.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.puzikov.serviceselector.dto.MovieDto;
import ru.puzikov.serviceselector.dto.response.MovieResponse;
import ru.puzikov.serviceselector.service.impl.MovieServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/movie/")
public class MovieController {
    private static final String GET_MOVIE = "get/";
    private static final String GET_ALL_MOVIES = "get/all";

    @Autowired
    MovieServiceImpl movieService;

    @GetMapping(value = GET_MOVIE)
    public ResponseEntity<MovieDto> getRandomMovie() {
        MovieDto movieDto = movieService.getMovie();

        if (movieDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(movieDto);
    }

    @GetMapping(value = GET_MOVIE + "{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable("id") Long id) {
        MovieDto movieDto = movieService.getMovieById(id);

        if (movieDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(movieDto);
    }

    @GetMapping(value = GET_ALL_MOVIES)
    public ResponseEntity<MovieResponse> getAllMovies() {
        List<MovieDto> movieDtos = movieService.getAll();
        
        MovieResponse movieResponse = movieService.formMovieResponse(movieDtos);
        System.out.println(movieResponse);

        return new ResponseEntity<>(movieResponse, movieResponse.getHttpStatus());
    }

    @PostMapping(value = "")
    public ResponseEntity<MovieDto> saveMovie(@RequestBody @Valid MovieDto movieDto) {

        if (movieDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        movieService.save(movieDto);

        return ResponseEntity.ok(movieDto);
    }

    @PutMapping(value = "")
    public ResponseEntity<MovieDto> updateMovie(@RequestBody MovieDto movieDto) {

        if (movieDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        movieService.update(movieDto);

        return ResponseEntity.ok(movieDto);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<MovieDto> deleteMovieById(@PathVariable("id") Long id) {
        MovieDto movieDto = movieService.getMovieById(id);

        if (movieDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        movieService.deleteById(id);

        return ResponseEntity.ok(movieDto);
    }

    @DeleteMapping(value = "delete/name/{name}")
    public ResponseEntity<MovieDto> deleteMovieByName(@PathVariable("name") String name) {
        MovieDto movieDto = movieService.getMovieByName(name);

        if (movieDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        movieService.deleteByName(name);

        return ResponseEntity.ok(movieDto);
    }

}
