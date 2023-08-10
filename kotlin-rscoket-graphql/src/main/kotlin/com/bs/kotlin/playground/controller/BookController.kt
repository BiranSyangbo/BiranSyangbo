package com.bs.kotlin.playground.controller

import com.bs.kotlin.playground.domain.Author
import com.bs.kotlin.playground.domain.Book
import com.bs.kotlin.playground.entities.BookEntity
import com.bs.kotlin.playground.repository.BookRepository
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class BookController(val bookRepository: BookRepository) {


//    @QueryMapping
//    fun bookById(@Argument id: String): Book {
//        return Book.getById(id);
//    }

    @MutationMapping
    fun saveBook(@Argument book: Book): Book {
        val entity = BookEntity();
        entity.id = book.id
        entity.authorId = book.authorId
        entity.name = book.name
        entity.pageCount = book.pageCount
        bookRepository.save(entity)
        return book;
    }

    @SchemaMapping
    fun author(book: Book): Author? {
        return Author.getById(book.authorId);
    }
}