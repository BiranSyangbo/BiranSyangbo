package com.spring.practice.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "b_words")
@Getter
@Setter
public class Words extends AbstractId {

    @Column(name = "raw_word")
    private String rawWord;

    @Column(name = "clean_word")
    private String cleanWord;

    @Column(name = "off_set")
    private Long off_set;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "verse_id")
//    private Verse verse;

//    @OneToMany(mappedBy = "words")
//    private List<Verse> verses;

    @OneToMany(mappedBy = "words")
    List<WordData> wordData;
}
