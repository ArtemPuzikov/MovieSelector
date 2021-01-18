package ru.puzikov.serviceselector.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
public class MovieDto {
    private Long id;
    private String name;
    private int year;
    private int rate;
    private String genre;
    private String description;

}
