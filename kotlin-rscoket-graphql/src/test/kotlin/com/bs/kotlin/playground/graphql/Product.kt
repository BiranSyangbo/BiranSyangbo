package com.bs.kotlin.playground.graphql

import graphql.GraphQLContext
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import java.time.LocalDateTime


fun main() {


    val fetcher: DataFetcher<List<Product>> = DataFetcher<List<Product>> { environment: DataFetchingEnvironment? ->
        val context: GraphQLContext? = environment?.graphQlContext
        var products: List<Product>? = null;
        val match = environment?.arguments?.get("match")
        products = Product.findAll()
        products
    }
}

private class Product(
    val id: Int? = null,
    val description: String? = null,
    val name: String? = null,
    val cost: Float? = null,
    val tax: Float? = null,
    val launchDate: LocalDateTime? = null
) {

    companion object {
        fun findAll(): List<Product> {
            return listOf(
                Product(1, "Desc1", "Product-1", 13.01f, 1.01f, LocalDateTime.now().plusDays(10)),
                Product(2, "Desc2", "Product-2", 15.01f, 1.02f, LocalDateTime.now().plusMonths(10)),
                Product(3, "Desc3", "Product-3", 12.01f, 1.03f, LocalDateTime.now().plusDays(100)),
                Product(4, "Desc4", "Product-4", 10.01f, 1.04f, LocalDateTime.now().plusDays(30)),
                Product(5, "Desc5", "Product-5", 19.011f, 2.01f, LocalDateTime.now().plusDays(50))
            )
        }
    }

}