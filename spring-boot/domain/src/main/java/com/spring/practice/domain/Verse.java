package com.spring.practice.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "b_verse")
@Data
public class Verse{

    @Column(name = "verse_no")
    private Integer number;

    @Column(name = "verse_style")
    private String style;

    @EmbeddedId
    private DataEmbed id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Chapter chapter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "words_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Words words;
}

@Embeddable
class DataEmbed {

    @Column(name = "chapter_id", insertable = false, updatable = false)
    private Long chapter;

    @Column(name = "words_id", insertable = false, updatable = false)
    private Long wordId;
}
