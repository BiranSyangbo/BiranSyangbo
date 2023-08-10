//package com.bs.kotlin.playground.config
//
//import com.bs.kotlin.playground.config.datafetcher.DataFetcherConfiguration
//import com.bs.kotlin.playground.repository.BookRepository
//import com.bs.kotlin.playground.repository.TestRepository
//import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer
//import org.springframework.graphql.execution.GraphQlSource.SchemaResourceBuilder
//import org.springframework.graphql.execution.ClassNameTypeResolver
//import org.springframework.graphql.execution.RuntimeWiringConfigurer
//import graphql.schema.idl.RuntimeWiring
//import graphql.schema.idl.SchemaDirectiveWiring
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//
//@Configuration(proxyBeanMethods = false)
//internal class GraphQlConfig {
//
//    @Bean
//    fun dataFetcherConfiguration(bookRepository: BookRepository, testRepository: TestRepository): DataFetcherConfiguration {
//        return DataFetcherConfiguration(bookRepository, testRepository);
//    }
//
//    @Bean
//    fun sourceBuilderCustomizer(): GraphQlSourceBuilderCustomizer {
//        return GraphQlSourceBuilderCustomizer { builder: SchemaResourceBuilder -> builder.defaultTypeResolver(ClassNameTypeResolver()) }
//    }
//
//    @Bean
//    fun runtimeWiringConfigurer(dataFetcherConfiguration: DataFetcherConfiguration): RuntimeWiringConfigurer {
//        return RuntimeWiringConfigurer { builder: RuntimeWiring.Builder ->
//            builder
//                    .type("Query") { typBuilder -> typBuilder.dataFetcher("findAll", dataFetcherConfiguration.multipleBookDataFetcher()) }
//                    .type("Query") { typBuilder -> typBuilder.dataFetcher("findById", dataFetcherConfiguration.singleBookDataFetcher()) }
//                    .type("Query") { typBuilder -> typBuilder.dataFetcher("testById", dataFetcherConfiguration.singleTest()) }
//                    .type("Query") { typBuilder -> typBuilder.dataFetcher("tests", dataFetcherConfiguration.multipleTest()) }
//                    .directiveWiring(object : SchemaDirectiveWiring {})
//        }
//    }
//}