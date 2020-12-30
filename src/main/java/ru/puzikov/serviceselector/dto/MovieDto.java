package ru.puzikov.serviceselector.dto;

import lombok.Data;

@Data
public class MovieDto {
  private String name;
  private int year;
  private int rate;
  private String genre;
  private String description;
}
