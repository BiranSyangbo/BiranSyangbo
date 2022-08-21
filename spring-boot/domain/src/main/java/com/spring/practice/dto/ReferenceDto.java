package com.spring.practice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReferenceDto {

    private String rawReference;
    private String shortRenderedReference;
    private String displayRenderedReference;
    private String renderedDataType;
    private String dataTypeAlias;

}
