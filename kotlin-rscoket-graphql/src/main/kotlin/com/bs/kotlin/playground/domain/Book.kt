package com.bs.kotlin.playground.domain

import java.util.*

class Book(val id: String, val name: String, val pageCount: Int, val authorId: String) {


    companion object {
        private val books = kotlin.collections.listOf(
                Book("book-1", "Harry Potter and the Philosopher's Stone", 223, "author-1"),
                Book("book-2", "Moby Dick", 635, "author-2"),
                Book("book-3", "Interview with the vampire", 371, "author-3")
        )

        fun getById(id: String): Book {
            return books.stream().filter { book: Book? -> book!!.id == id }
                    .findFirst().orElse(null)
        }

        fun book(): List<Book> {
            return books;
        }
    }

    override fun toString(): String {
        return "Book(id='$id', name='$name', pageCount=$pageCount, authorId='$authorId')"
    }
}