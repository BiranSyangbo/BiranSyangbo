package com.spring.practice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WordDataDto {

    private String kind;

    private String title;

    private String description;

    private String icon;

    private String titleLanguage;

    private ReferenceDto referenceInfo;
}
