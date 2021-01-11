package ru.puzikov.serviceselector;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.puzikov.serviceselector.domain.Movie;
import ru.puzikov.serviceselector.repository.MovieRepository;

@SpringBootApplication
public class MovieSelectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieSelectorApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
		return args -> {
			Movie movie = new Movie("Matrix", 1999,10,"sci-fi", "cool movie");
			Movie movie2 = new Movie("Matrix2", 2000,10,"sci-fi", "cool movie");
			Movie movie3 = new Movie("Fast and the furious", 2004,8,"action", "Film about bald man and family theme");
			movieRepository.save(movie);
			movieRepository.save(movie2);
			movieRepository.save(movie3);
		};
	}

}
