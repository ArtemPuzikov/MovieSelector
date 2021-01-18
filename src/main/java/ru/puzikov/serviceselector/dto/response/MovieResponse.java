package ru.puzikov.serviceselector.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.puzikov.serviceselector.dto.MovieDto;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovieResponse {
    List<MovieDto> movies;
}
