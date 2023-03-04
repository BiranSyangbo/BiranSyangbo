package com.spring.practice.integration.flow;

import com.spring.practice.integration.FileMessageToJobRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.integration.launch.JobLaunchingGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.util.Assert;

import java.io.File;

/**
 * Read the data from folder and inserted into the database
 * on given path if we drop the new .csv file it will read on event and start inserted into db
 */

@Configuration
@RequiredArgsConstructor
public class BatchFileIntegrationFlow {

    private final JobRepository jobRepository;
    private static final File filePath = new File(System.getProperty("user.home") + "/file/");


    @Bean
    public FileMessageToJobRequest fileMessageToJobRequest(Job countryJob) {
        return new FileMessageToJobRequest("file.path", countryJob);
    }


    @Bean
    public JobLaunchingGateway jobLaunchingGateway() {
        TaskExecutorJobLauncher jobLauncher = new TaskExecutorJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        jobLauncher.setTaskExecutor(new SyncTaskExecutor());
        return new JobLaunchingGateway(jobLauncher);
    }

    @Bean
    public IntegrationFlow integrationFlow(JobLaunchingGateway jobLaunchingGateway) {
        Assert.state(filePath.exists() || filePath.mkdir(), "Path must be exists");
        return IntegrationFlow.from(Files.inboundAdapter(filePath).
                        filter(new SimplePatternFileListFilter("*.csv")),
                c -> c.poller(Pollers.fixedRate(1000).maxMessagesPerPoll(1))).
                transform(fileMessageToJobRequest(null)).
                handle(jobLaunchingGateway).
                log(LoggingHandler.Level.WARN, "headers.id + ': ' + payload").
                get();
    }
}
