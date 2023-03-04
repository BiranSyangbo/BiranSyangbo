package com.spring.practice.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.integration.launch.JobLaunchRequest;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;

import java.io.File;

/**
 * Read me more {@link com.spring.practice.integration.flow.BatchFileIntegrationFlow}
 */
@RequiredArgsConstructor
public class FileMessageToJobRequest {

    private final String filePath;
    private final Job job;

    @Transformer
    public JobLaunchRequest toRequest(Message<File> message) {
        JobParametersBuilder jobParametersBuilder =
                new JobParametersBuilder();
        jobParametersBuilder.addString(filePath, message.getPayload().getAbsolutePath());

        return new JobLaunchRequest(job, jobParametersBuilder.toJobParameters());
    }
}
