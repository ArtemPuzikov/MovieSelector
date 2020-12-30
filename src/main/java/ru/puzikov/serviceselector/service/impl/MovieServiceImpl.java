package ru.puzikov.serviceselector.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.puzikov.serviceselector.repository.MovieRepository;
import ru.puzikov.serviceselector.service.MovieService;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

  private final MovieRepository movieRepository; //так происходит инжект бина (Lombok @RequiredArgsConstructor) Лучший вариант, так как поле final позволяет сохранить класс неизменяемым

}
