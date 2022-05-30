package com.spring.practice.controller;

import com.spring.practice.service.ZipUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/concurrency")
@RequiredArgsConstructor
public class ZipUploadController {

    private final ZipUploadService zipUploadService;

    @PostMapping("/zip/upload")
    public String uploadZip(@RequestPart("file") MultipartFile file) {
        zipUploadService.uploadZipFile(file);
        return "Hello";
    }

    @GetMapping({"/", ""})
    public String test() {
        return "Test";
    }

}