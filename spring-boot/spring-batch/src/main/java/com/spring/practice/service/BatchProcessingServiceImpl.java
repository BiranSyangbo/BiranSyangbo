package com.spring.practice.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BatchProcessingServiceImpl implements BatchProcessingService {

    private final JobLauncher jobLauncher;
    private final Job countryJob;
    private final Job dataTransferJob;

    @Override
    @SneakyThrows
    public BatchStatus loadDataFromCsvToDB() {
        String parameter = LocalDate.now().toString();
        var run = jobLauncher.run(countryJob, new JobParametersBuilder().addString("date", parameter)
                .toJobParameters());
        return run.getStatus();
    }

    @Override
    @SneakyThrows
    public BatchStatus transferDBDataToES() {
        return jobLauncher
                .run(dataTransferJob, new JobParametersBuilder().addString("Uid", UUID.randomUUID().toString()).toJobParameters())
                .getStatus();
    }


}
