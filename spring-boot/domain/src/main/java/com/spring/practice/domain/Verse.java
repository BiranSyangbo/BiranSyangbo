package com.spring.practice.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "b_verse")
@Data
public class Verse extends AbstractId{

    @Column(name = "verse_no")
    private Integer number;

    @Column(name = "verse_style")
    private String style;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @OneToMany(mappedBy = "verse")
    private List<Words> words;
}
