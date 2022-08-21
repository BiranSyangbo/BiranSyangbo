package com.spring.practice.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "b_book")
@Data
public class Book extends AbstractId {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "book_name")
    private String book;

    @OneToMany(mappedBy = "book")
    private List<Chapter> chapterList;

}
