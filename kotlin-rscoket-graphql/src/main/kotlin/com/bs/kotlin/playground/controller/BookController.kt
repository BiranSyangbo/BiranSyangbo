package com.bs.kotlin.playground.controller

import com.bs.kotlin.playground.domain.Author
import com.bs.kotlin.playground.domain.Book
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class BookController {

    @QueryMapping
    fun bookById(@Argument id: String): Book {
        return Book.getById(id);
    }

    @QueryMapping
    fun books(): List<Book> {
        return Book.book();
    }

    @SchemaMapping
    fun author(book: Book): Author? {
        return Author.getById(book.authorId);
    }
}