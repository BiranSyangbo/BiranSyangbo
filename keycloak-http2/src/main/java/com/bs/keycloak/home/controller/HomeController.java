package com.bs.keycloak.home.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
public class HomeController {

    AtomicInteger atom = new AtomicInteger(0);

    @GetMapping("/")
    @Async("taskExecutorService")
    public ResponseEntity<String> getMessage() {
        System.out.println(atom.incrementAndGet());
        return ResponseEntity.ok("Hello");
    }
}
