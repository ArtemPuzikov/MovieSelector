package ru.puzikov.serviceselector.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;
import ru.puzikov.serviceselector.dto.MovieDto;

import java.util.List;

@Getter
@Setter
@ToString(of = "movies")
@NoArgsConstructor
public class MovieResponse {
    List<MovieDto> movies;

   private HttpStatus httpStatus;


}
