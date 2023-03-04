package com.spring.practice.controller;

import com.spring.practice.service.BatchProcessingService;
import com.spring.practice.service.ZipUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
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


}
