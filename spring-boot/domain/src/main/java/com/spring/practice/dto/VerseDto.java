package com.spring.practice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VerseDto {
    private String style;
    private int number;
    private List<WordsDto> words;
}
