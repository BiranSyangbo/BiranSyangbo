package com.spring.practice.batch;

import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class CItemReader {


    @Value("classpath:batch/country/data/country.csv")
    public Resource resource;

    @Bean
    public ItemReader<CountryData> countryDataReader() {
        return new FlatFileItemReaderBuilder<CountryData>()
                .resource(resource)
                .name("Company Details")
                .delimited()
                .delimiter(",")
                .names("name,website,industry,size_range,current_employee_estimate,total_employee_estimate,country,locality,region,year_founded,linkedin_url".split(","))
                .linesToSkip(1)
                .fieldSetMapper(fieldSet -> new CountryData(
                        fieldSet.readString("name"),
                        fieldSet.readString("website"),
                        fieldSet.readString("industry"),
                        fieldSet.readString("size_range"),
                        parseInt(fieldSet.readString("current_employee_estimate"), 0),
                        parseInt(fieldSet.readString("total_employee_estimate"), 0),
                        fieldSet.readString("country"),
                        fieldSet.readString("locality"),
                        fieldSet.readString("region"),
                        parseInt(fieldSet.readString("year_founded"), 1997),
                        fieldSet.readString("linkedin_url"))
                ).build();
    }

    private int parseInt(String year, int value) {
        return StringUtils.isBlank(year) ? value : Integer.parseInt(year);
    }
}
