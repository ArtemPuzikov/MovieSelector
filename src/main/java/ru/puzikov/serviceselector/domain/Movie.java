package ru.puzikov.serviceselector.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@Entity
@EqualsAndHashCode
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

    public Movie(){

    }

    public Movie(@NotNull String name, @NotNull int year, @NotNull int rate, @NotNull String genre, @NotNull String description) {

        this.name = name;
        this.year = year;
        this.rate = rate;
        this.genre = genre;
        this.description = description;
    }
}
