package com.spring.practice.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "b_words")
@Data
public class Words extends AbstractId {

    @Column(name = "raw_word")
    private String rawWord;

    @Column(name = "clean_word")
    private String cleanWord;

    @Column(name = "offset")
    private Long offset;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "verse_id")
//    private Verse verse;

//    @OneToMany(mappedBy = "words")
//    private List<Verse> verses;

    @OneToMany(mappedBy = "words")
    List<WordData> wordData;
}
