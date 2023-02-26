package com.spring.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BatchProcessingServiceImpl implements BatchProcessingService {

    private final JobLauncher jobLauncher;
    private final Job countryJob;

    @Override
    public BatchStatus batchProcessing() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        String parameter = LocalDate.now().toString();
        var run = jobLauncher.run(countryJob, new JobParametersBuilder().addString("date", parameter)
                .toJobParameters());
        return run.getStatus();
    }
}
