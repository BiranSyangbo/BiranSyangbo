package com.bs.kotlin.playground.repository

import com.bs.kotlin.playground.entities.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.QueryByExampleExecutor
import org.springframework.graphql.data.GraphQlRepository
import java.util.*

@GraphQlRepository
interface BookRepository : JpaRepository<BookEntity, String>, QueryByExampleExecutor<BookEntity> {
    override fun findById(id: String): Optional<BookEntity>
    override fun findAll(): MutableList<BookEntity>
}