package ru.puzikov.serviceselector.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MovieRequest {
    //какие то поля для будущих запросов

    private String name;
    private int year;
    private int rate;
    private String genre;
    private String description;
}
