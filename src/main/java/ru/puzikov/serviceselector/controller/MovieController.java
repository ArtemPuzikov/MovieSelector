package ru.puzikov.serviceselector.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
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
    private HttpHeaders header;

    @Autowired
    MovieServiceImpl movieService;

    @RequestMapping(value = GET_MOVIE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRandomMovie() {
        header = getHttpHeader();
        MovieDto movieDto = this.movieService.getMovie();

        if (movieDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(movieDto);
    }

    @RequestMapping(value = GET_MOVIE + "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMovie(@PathVariable("id") Long id) {
        header = getHttpHeader();
        MovieDto movieDto = this.movieService.getMovieById(id);

        if (movieDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(movieDto);
    }

    @RequestMapping(value = GET_ALL_MOVIES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllMovies() {
        header = getHttpHeader();
        List<MovieDto> movieDtos = this.movieService.getAll();

        if (movieDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        MovieResponse movieResponse = new MovieResponse(movieDtos);

        return ResponseEntity.ok(movieResponse.getMovies());
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveMovie(@RequestBody @Valid MovieDto movieDto) {
        header = getHttpHeader();

        if (movieDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.movieService.save(movieDto);

        return ResponseEntity.ok(movieDto);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMovie(@RequestBody MovieDto movieDto) {
        header = getHttpHeader();

        if (movieDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.movieService.update(movieDto);

        return ResponseEntity.ok(movieDto);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteMovieById(@PathVariable("id") Long id) {
        header = getHttpHeader();
        MovieDto movieDto = this.movieService.getMovieById(id);

        if (movieDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        movieService.deleteById(id);

        return ResponseEntity.ok(movieDto);
    }

    @RequestMapping(value = "delete/name/{name}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteMovieByName(@PathVariable("name") String name) {
        header = getHttpHeader();
        MovieDto movieDto = this.movieService.getMovieByName(name);

        if (movieDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        movieService.deleteByName(name);

        return ResponseEntity.ok(movieDto);
    }

    public HttpHeaders getHttpHeader() {
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "MovieResponse");
        return header;
    }

}
