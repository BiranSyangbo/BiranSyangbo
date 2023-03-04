package com.spring.practice.es.load;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.practice.batch.CItemReader;
import com.spring.practice.batch.CompanyData;
import com.spring.practice.es.load.dto.CompanyEsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DataTransfer {

    public final JobRepository jobRepository;
    public final PlatformTransactionManager transactionManager;
    private final DataSource dataSource;
    private final ObjectMapper objectMapper;

    final RowMapper<CompanyEsDto> rowMapper = (rs, rowNum) -> {
        int year = rs.getInt("year");
        String data = rs.getString("data");
        return new CompanyEsDto(year, convertToObject(data));
    };

    private ArrayList<CompanyData> convertToObject(String data) {
        try {
            return objectMapper.readValue(data, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public ItemReader<CompanyEsDto> loadDataFromDB() {
        return new JdbcCursorItemReaderBuilder<CompanyEsDto>()
                .name("dbDataLoader")
                .sql("select a.year as year,  (select jsonb_agg(c) as data from company_details c where c.year = a.year)\n" +
                        "from (select year from company_details group by year order by year) as a;")
                .dataSource(this.dataSource)
                .fetchSize(100)
                .rowMapper(this.rowMapper)
                .build();
    }

    @Bean
    public Step dataTransferStep() {
        return new StepBuilder("dataTransferStepBuilder", jobRepository)
                .<CompanyEsDto, CompanyEsDto>chunk(10, transactionManager)
                .reader(loadDataFromDB())
                .writer(chunk -> System.out.println(chunk.getItems()))
                .build();
    }

    @Bean
    public Job dataTransferJob() {
        return new JobBuilder("dataTransferJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(dataTransferStep())
                .build();
    }


}
