package com.spring.practice.batch.config;

import com.spring.practice.batch.listener.CustomJobExecutionListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.*;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Date;

@Slf4j
@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class BatchConfig {

    private final CustomJobExecutionListener customJobExecutionListener;
    private final JobRepository jobRepository;


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
    public Job job(Step step, Step loadData) {
        return new JobBuilder("Demo", jobRepository)
                .listener(customJobExecutionListener)
                .start(step)
//                .next(loadData)
                .build();
    }

    @Bean
    public Step step( Tasklet tasklet, PlatformTransactionManager transactionManager) {
        return new StepBuilder("Step1", jobRepository)
                .tasklet(tasklet, transactionManager)
                .build();
    }

    @Bean
    public Step loadData(PlatformTransactionManager transactionManager) {
        return new StepBuilder("StepBuilder", jobRepository)
                .<String, String>chunk(1, transactionManager)
                .reader(new ItemReader<String>() {
                    @Override
                    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
                        System.out.println("Reading Data");
                        return "ABC";
                    }
                })
                .writer(new ItemWriter<String>() {
                    @Override
                    public void write(Chunk<? extends String> chunk) throws Exception {

                    }
                })
                .startLimit(1)
                .build();
    }

    private void print(Chunk<?> chunk) {
        System.out.println(chunk.getItems());
        return;
    }



}
