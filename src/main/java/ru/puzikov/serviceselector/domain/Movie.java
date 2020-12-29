package ru.puzikov.serviceselector.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "MOVIE_TABLE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "year")
    private int year;

    @NotNull
    @Column(name = "rate")
    private int rate;

    @NotNull
    @Column(name = "genre")
    private String genre;

    @NotNull
    @Column(name = "description")
    private String description;

    public Movie(@NotNull String name, @NotNull int year, @NotNull int rate, @NotNull String genre, @NotNull String description) {
        this.name = name;
        this.year = year;
        this.rate = rate;
        this.genre = genre;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year &&
                rate == movie.rate &&
                id.equals(movie.id) &&
                name.equals(movie.name) &&
                genre.equals(movie.genre) &&
                description.equals(movie.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, rate, genre, description);
    }
}
