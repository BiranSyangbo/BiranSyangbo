package com.spring.practice.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BatchProcessingServiceImpl implements BatchProcessingService {

    private final JobLauncher jobLauncher;
    private final Job job;

    @Override
    @SneakyThrows
    public BatchStatus batchProcessing() {
        JobExecution jobStatus = jobLauncher.run(job, new JobParametersBuilder().addString("Id", UUID.randomUUID().toString()).toJobParameters());
        return jobStatus.getStatus();
    }
}
