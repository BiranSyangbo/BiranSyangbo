package com.spring.practice.batch.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomJobExecutionListener {

    @BeforeJob
    public void beforeJobExecution(JobExecution jobExecution) {
        log.info("Process is started {}", jobExecution);
    }

    @AfterJob
    public void afterJobExecution(JobExecution jobExecution) {
        log.info("Job Details :-{}", jobExecution);
    }

}
