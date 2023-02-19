package com.spring.practice.service;

import org.springframework.batch.core.BatchStatus;

import java.io.InputStream;

public interface BatchProcessingService {

    BatchStatus batchProcessing();
}
