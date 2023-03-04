package com.spring.practice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

public class HomePageDto extends RepresentationModel<HomePageDto> {

    private final String message;

    @JsonCreator
    public HomePageDto(@JsonProperty("message") String message) {
        this.message = message;
    }

    public String getContent() {
        return message;
    }
}
