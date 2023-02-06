package com.bs.keycloak.home.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
@ConditionalOnProperty({"enable.controller.default", "enable.controller.custom"})
public class HomeController {

    AtomicInteger atom = new AtomicInteger(0);

    @GetMapping("/")
//    @Async("taskExecutorService")
    public ResponseEntity<String> getMessage() {
        System.out.println(atom.incrementAndGet());
        return ResponseEntity.ok("Hello");
    }
}
