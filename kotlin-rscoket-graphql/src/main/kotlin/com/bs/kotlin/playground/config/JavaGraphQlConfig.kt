package com.bs.kotlin.playground.config

import com.bs.kotlin.playground.config.datafetcher.DataFetcherConfiguration
import com.bs.kotlin.playground.repository.BookRepository
import com.bs.kotlin.playground.repository.TestRepository
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.TypeRuntimeWiring
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.RuntimeWiringConfigurer

@Configuration
class JavaGraphQlConfig {
    @Bean
    fun dataFetcherConfiguration(bookRepository: BookRepository?, testRepository: TestRepository): DataFetcherConfiguration {
        return DataFetcherConfiguration(bookRepository!!, testRepository!!)
    }

    @Bean
    fun runtimeWiringConfigurer(dataFetcherConfiguration: DataFetcherConfiguration): RuntimeWiringConfigurer {
        return RuntimeWiringConfigurer { builder: RuntimeWiring.Builder ->
            builder
                    .type("Query") { typBuilder: TypeRuntimeWiring.Builder -> typBuilder.dataFetcher("findAll", dataFetcherConfiguration.multipleBookDataFetcher()) }
                    .type("Query") { typBuilder: TypeRuntimeWiring.Builder -> typBuilder.dataFetcher("findById", dataFetcherConfiguration.singleBookDataFetcher()) }
                    .type("Query") { typBuilder: TypeRuntimeWiring.Builder -> typBuilder.dataFetcher("testById", dataFetcherConfiguration.singleTest()) }
                    .type("Query") { typBuilder: TypeRuntimeWiring.Builder -> typBuilder.dataFetcher("tests", dataFetcherConfiguration.multipleTest()) }
        }
    }
}