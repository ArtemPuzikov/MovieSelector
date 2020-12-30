package ru.puzikov.serviceselector.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.puzikov.serviceselector.dto.MovieDto;

@Data
@AllArgsConstructor
public class MovieResponse {
  List<MovieDto> movies;
}
