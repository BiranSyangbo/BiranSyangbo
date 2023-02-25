package com.spring.practice.batch.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CustomJobLauncher {

    private final JobRepository jobRepository;


}
