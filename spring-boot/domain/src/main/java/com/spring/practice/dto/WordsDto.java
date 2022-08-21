package com.spring.practice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WordsDto {

    private String rawWord;

    private String cleanWord;

    private long offset;

    private List<WordDataDto> data;

}
