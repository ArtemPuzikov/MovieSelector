package ru.puzikov.serviceselector.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
}
