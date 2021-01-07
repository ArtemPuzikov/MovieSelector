package ru.puzikov.serviceselector.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.puzikov.serviceselector.domain.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    Movie findMovieById(Long id);

    List<Movie> findAll();

    Movie findMovieByName(String name);
}
