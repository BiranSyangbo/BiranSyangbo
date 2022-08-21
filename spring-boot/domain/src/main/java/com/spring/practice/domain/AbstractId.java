package com.spring.practice.domain;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class AbstractId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unique_generator" )
    @SequenceGenerator(name = "unique_generator", sequenceName = "id")
    private Long id;
}
