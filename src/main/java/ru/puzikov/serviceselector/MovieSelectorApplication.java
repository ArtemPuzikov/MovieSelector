package ru.puzikov.serviceselector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import ru.puzikov.serviceselector.domain.Movie;
import ru.puzikov.serviceselector.repository.MovieRepository;

@SpringBootApplication
public class MovieSelectorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MovieSelectorApplication.class, args);
		MovieRepository movieRepository = context.getBean(MovieRepository.class);
		Movie movie = new Movie("Matrix", 1999,10,"sci-fi", "cool movie");
		movieRepository.save(movie);
	}

}
