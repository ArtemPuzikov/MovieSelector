package ru.puzikov.serviceselector.controller;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.puzikov.serviceselector.dto.response.MovieResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/movie")
public class MovieController {
  private static final String GET_MOVIE = "/get";

  @GetMapping(GET_MOVIE)
  public ResponseEntity<MovieResponse> getMovie() {
    return ResponseEntity.ok(new MovieResponse(Arrays.asList()));
  }

}
