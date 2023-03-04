package com.spring.practice.batch.config;

import com.spring.practice.batch.CItemProcessor;
import com.spring.practice.batch.CItemReader;
import com.spring.practice.batch.CItemWriter;
import com.spring.practice.batch.CompanyData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CountryDataBatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final CItemReader itemReader;
    private final CItemWriter itemWriter;
    private final CItemProcessor itemProcessor;


    @Bean
    public Job countryJob(Step countryRunnerStep) {
        return new JobBuilder("countryDataLoader", jobRepository)
                .start(countryRunnerStep)
                .build();
    }

    @Bean
    public Step countryRunnerStep() {
        return new StepBuilder("CountryDataLoaderStep", jobRepository)
                .<CompanyData, CompanyData>chunk(10000, transactionManager)
                .reader(itemReader.countryDataReader())
                .processor(itemProcessor)
                .writer(itemWriter.countryDataLoader())
                .build();
    }
}
