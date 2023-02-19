package com.spring.practice.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                                "company_name", item.name(),
                                "website", item.webSite(),
                                "industry", item.industry(),
                                "range", item.range(),
                                "no_of_employee", item.noOfEmployee(),
                                "est_no_of_employee", item.estNoOfEmployee(),
                                "country", item.country(),
                                "locality", item.locality(),
                                "region", item.region(),
                                "url", item.url()))
                        .addValues(Map.of("year", item.year()))
                )
                .itemPreparedStatementSetter((item, ps) -> {
                    int i = 0;
                    ps.setString(i++, item.name());
                    ps.setString(i++, item.webSite());
                    ps.setString(i++, item.industry());
                    ps.setString(i++, item.range());
                    ps.setInt(i++, item.noOfEmployee());
                    ps.setInt(i++, item.estNoOfEmployee());
                    ps.setString(i++, item.country());
                    ps.setString(i++, item.locality());
                    ps.setString(i++, item.region());
                    ps.setInt(i++, item.year());
                    ps.setString(i++, item.url());
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
            );
            """;
}
