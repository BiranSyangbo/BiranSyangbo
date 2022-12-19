package com.spring.practice.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "b_chapter")
@Data
public class Chapter extends AbstractId{

    @Column(name = "chapter_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "books_id")
    private Book book;

//    @OneToMany(mappedBy = "chapter")
//    private List<Verse> verses;
}
