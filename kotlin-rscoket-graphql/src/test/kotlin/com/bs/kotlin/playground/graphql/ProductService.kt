package com.bs.kotlin.playground.graphql

import graphql.ExecutionResult
import graphql.GraphQL
import graphql.schema.DataFetcher
import java.time.LocalDateTime
import java.util.*


fun main() {
    saveProduct()
}

fun saveProduct() {

    fun fetcher(): MutableMap<String, DataFetcher<Any>> {
        val fetcher = DataFetcher<Any> { environment ->

            val product: Map<String, Objects> = environment.arguments.get("product") as Map<String, Objects>
            println(product)
            val tax = product["tax"] as Double?
            val cost = product["cost"] as Double?
            Product(999, "", product["name"] as String?, cost?.toFloat(), tax?.toFloat(), LocalDateTime.now())
        }
        val map = HashMap<String, DataFetcher<Any>>()
        map.put("saveProduct", fetcher);
        return map
    }

    var graphQl: GraphQL = GraphQlBuilder(fetcher()).getGraphQl("products.graphqls")
    val res: ExecutionResult = graphQl.execute("""
        {
          product: saveProduct(product: {name: "Biran", tax: 12}) {
            name
            tax,
            launchDate
          }
        }
    """.trimIndent())

    println(res.toSpecification())

}