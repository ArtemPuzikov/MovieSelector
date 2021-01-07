package ru.puzikov.serviceselector.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.Builder;


@Builder
@Data
public class MovieDto {
    private String name;
    private int year;
    private int rate;
    private String genre;
    private String description;


}
