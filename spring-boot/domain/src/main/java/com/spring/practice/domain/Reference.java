package com.spring.practice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "b_reference")
@Getter
@Setter
public class Reference extends AbstractId{

    @Column(name = "raw_reference")
    private String rawReference;

    @Column(name = "short_rendered_reference")
    private String shortRenderedReference;

    @Column(name = "display_rendered_reference")
    private String displayRenderedReference;

    @Column(name = "rendered_data_type")
    private String renderedDataType;

    @Column(name = "data_type_alias")
    private String dataTypeAlias;
}
