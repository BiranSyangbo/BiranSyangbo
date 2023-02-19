package com.spring.practice.batch.config;

import com.spring.practice.batch.CountryData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Date;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CountryDataBatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean
    ApplicationRunner runner(JobLauncher jobLauncher, Job countryJob) {
        Date parameter = new Date();
        return args -> {
            var run = jobLauncher.run(countryJob, new JobParametersBuilder().addDate("date", parameter).toJobParameters());
            System.out.println(run.getStatus());
        };
    }

    @Bean
    public Job countryJob(Step countryRunnerStep) {
        return new JobBuilder("countryDataLoader", jobRepository)
                .start(countryRunnerStep)
                .build();
    }

    @Bean
    public Step countryRunnerStep(ItemReader<CountryData> countryDataReader, ItemWriter<CountryData> countryDataLoader) {
        return new StepBuilder("CountryDataLoaderStep", jobRepository)
                .<CountryData, CountryData>chunk(100, transactionManager)
                .reader(countryDataReader)
                .writer(countryDataLoader).build();
    }
}
