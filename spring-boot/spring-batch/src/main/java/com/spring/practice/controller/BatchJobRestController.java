package com.spring.practice.controller;

import com.spring.practice.dto.HomePageDto;
import com.spring.practice.service.BatchProcessingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/batch")
public class BatchJobRestController {

    private final BatchProcessingService batchProcessingService;

    @GetMapping({"/", "", "/home"})
    public HttpEntity<HomePageDto> home() {
        var model = new HomePageDto("Welcome to batch processing");
        model.add(linkTo(methodOn(BatchJobRestController.class).home()).withSelfRel());
        model.add(linkTo(methodOn(BatchJobRestController.class).loadDataFromCsvToDB()).withRel("load-data-to-db"));
        model.add(linkTo(methodOn(BatchJobRestController.class).transferDataDBToES()).withRel("load-data-to-db"));
        return ResponseEntity.ok(model);
    }

    @GetMapping({"/csv/data/load"})
    public ResponseEntity<String> loadDataFromCsvToDB() {
        return ResponseEntity.ok(batchProcessingService.loadDataFromCsvToDB().toString());
    }

    @GetMapping({"/es/data/transfer"})
    public ResponseEntity<String> transferDataDBToES() {
        return ResponseEntity.ok(batchProcessingService.transferDBDataToES().toString());
    }

}
