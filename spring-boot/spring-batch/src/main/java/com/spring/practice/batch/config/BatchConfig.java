package com.spring.practice.batch.config;

import com.spring.practice.batch.listener.CustomJobExecutionListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {

    public static final String STEP_ERROR = "Step_Error";
    public static final String COMPLETED = "Complete";
    private final CustomJobExecutionListener customJobExecutionListener;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    ApplicationRunner runner1(JobLauncher jobLauncher) {
        return args -> jobLauncher.run(job(null),
                new JobParametersBuilder().addString("Uid", UUID.randomUUID().toString())
                        .toJobParameters());
    }

    @Bean
    public JobLauncher jobLauncher() throws Exception {
        var launcher = new TaskExecutorJobLauncher();
        launcher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        launcher.setJobRepository(jobRepository);
        launcher.afterPropertiesSet();
        return launcher;
    }

    @Bean
    @StepScope
    public Tasklet tasklet(@Value("#{jobParameters['date']}") Date date) {
        return (contribution, chunkContext) -> {
            System.out.println("Hello Biran " + date);
            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Job job(Step step) {
        return new JobBuilder("Demo", jobRepository)
                .listener(customJobExecutionListener)
                .start(step)
                .on(STEP_ERROR)
                .to(loadData())
                .from(step).on(COMPLETED)
                .to(step3())
                .end()
                .build();
    }

    @Bean
    Step step3() {
        return new StepBuilder("Step 2", jobRepository)
                .tasklet(tasklet3(), transactionManager)
                .build();
    }

    @Bean
    Tasklet tasklet3() {
        return (contribution, chunkContext) -> {
            log.warn("Third Task let is triggered");
            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Step step(Tasklet tasklet) {
        return new StepBuilder("Step1", jobRepository)
                .tasklet(tasklet, transactionManager)
                .listener(new StepExecutionListener() {
                    @Override
                    public void beforeStep(StepExecution stepExecution) {
                        StepExecutionListener.super.beforeStep(stepExecution);
                    }

                    @Override
                    public ExitStatus afterStep(StepExecution stepExecution) {
                        if (new Random().nextBoolean())
                            return new ExitStatus(COMPLETED);
                        return new ExitStatus(STEP_ERROR);
                    }
                })
                .build();
    }

    @Bean
    public Step loadData() {
        return new StepBuilder("StepBuilder", jobRepository)
                .tasklet(tasklet2(), transactionManager)
                .listener(new StepExecutionListener() {
                    @Override
                    public ExitStatus afterStep(StepExecution stepExecution) {
                        System.out.println("Load Data");
                        return ExitStatus.COMPLETED;
                    }
                })
                .build();
    }

    @Bean
    Tasklet tasklet2() {
        return (contribution, chunkContext) -> {
            log.error("Second tasklet triggered");
            return RepeatStatus.FINISHED;
        };
    }

}
