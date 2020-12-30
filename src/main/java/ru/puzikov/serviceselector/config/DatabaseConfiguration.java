package ru.puzikov.serviceselector.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"ru.puzikov.serviceselector.domain"})
public class DatabaseConfiguration {
}
