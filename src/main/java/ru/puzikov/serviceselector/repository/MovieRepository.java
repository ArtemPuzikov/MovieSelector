package ru.puzikov.serviceselector.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.puzikov.serviceselector.domain.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
