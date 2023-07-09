package com.bs.kotlin.playground.domain

class Author(val id: String, val firstName: String, val lastName: String) {


    companion object {
        private val authors: List<Author> = listOf(
            Author("author-1", "Joanne", "Rowling"),
            Author("author-2", "Herman", "Melville"),
            Author("author-3", "Anne", "Rice")
        )

        fun getById(id: String): Author {
            return authors
                .stream()
                .filter { author: Author? -> author!!.id == id }
                .findFirst().orElseGet(null);
        }
    }
}