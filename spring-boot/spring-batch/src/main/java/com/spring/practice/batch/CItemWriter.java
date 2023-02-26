package com.spring.practice.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class CItemWriter {

    private final DataSource dataSource;

    @Bean
    public ItemWriter<CountryData> countryDataLoader() {
        return new JdbcBatchItemWriterBuilder<CountryData>()
                .sql(sql)
                .dataSource(dataSource)
                .itemSqlParameterSourceProvider(item -> new MapSqlParameterSource()
                        .addValues(Map.of(
                                "company_name", item.getName(),
                                "website", item.getWebSite(),
                                "industry", item.getIndustry(),
                                "range", item.getRange(),
                                "no_of_employee", item.getNoOfEmployee(),
                                "est_no_of_employee", item.getEstNoOfEmployee(),
                                "country", item.getCountry(),
                                "locality", item.getLocality(),
                                "region", item.getRegion(),
                                "url", item.getUrl()))
                        .addValues(Map.of("year", item.getYear()))
                )
                .itemPreparedStatementSetter((item, ps) -> {
                    int i = 0;
                    ps.setString(i++, item.getName());
                    ps.setString(i++, item.getWebSite());
                    ps.setString(i++, item.getIndustry());
                    ps.setString(i++, item.getRange());
                    ps.setInt(i++, item.getEstNoOfEmployee());
                    ps.setInt(i++, item.getEstNoOfEmployee());
                    ps.setString(i++, item.getCountry());
                    ps.setString(i++, item.getLocality());
                    ps.setString(i++, item.getRegion());
                    ps.setInt(i++, item.getYear());
                    ps.setString(i++, item.getUrl());
                })
                .build();
    }

    private static final String sql = """
            INSERT INTO company_info (
                company_name, 
                website, 
                industry, 
                range, 
                no_of_employee, 
                est_no_of_employee, 
                country,
                locality, 
                region, 
                year, 
                url)
            VALUES (
                :company_name,
                :website,
                :industry,
                :range,
                :no_of_employee,
                :est_no_of_employee,
                :country,
                :locality,
                :region,
                :year,
                :url
            ) ON CONFLICT ON CONSTRAINT company_info_pkey 
               DO UPDATE SET range = excluded.range,
               no_of_employee = excluded.no_of_employee,
               url = excluded.url,
               region = excluded.region,
               est_no_of_employee = excluded.est_no_of_employee;
            """;
}
