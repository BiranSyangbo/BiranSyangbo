package com.bs.kotlin.playground.config.datafetcher

import com.bs.kotlin.playground.repository.BookRepository
import graphql.schema.DataFetcher
import com.bs.kotlin.playground.entities.BookEntity
import com.bs.kotlin.playground.entities.Test
import com.bs.kotlin.playground.repository.TestRepository
import org.springframework.graphql.data.query.QueryByExampleDataFetcher

class DataFetcherConfiguration(private val bookRepository: BookRepository, private val testRepository: TestRepository) {
    fun singleBookDataFetcher(): DataFetcher<BookEntity> {
        return QueryByExampleDataFetcher.builder(bookRepository).single()
    }

    fun multipleBookDataFetcher(): DataFetcher<Iterable<BookEntity>> {
        return QueryByExampleDataFetcher.builder(bookRepository).many()
    }

    fun singleTest(): DataFetcher<Test> {
        return QueryByExampleDataFetcher.builder(testRepository).single();
    }


    fun multipleTest(): DataFetcher<Iterable<Test>> {
        return QueryByExampleDataFetcher.builder(testRepository).many();
    }
}