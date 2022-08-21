package com.spring.practice.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "b_word_data")
@Data
public class WordData extends AbstractId {

    @Column(name = "kind")
    private String kind;

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private String icon;

    @Column(name = "title_language")
    private String titleLanguage;

    @ManyToOne
    @JoinColumn(name = "words_id")
    private Words words;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reference_id")
    private Reference reference;
}
