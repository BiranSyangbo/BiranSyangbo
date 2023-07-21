package com.bs.kotlin.playground.graphql

import graphql.ExecutionResult
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import java.util.*

fun main() {

    fun dataFetcher(): MutableMap<String, DataFetcher<Any>> {
        val fetcher = DataFetcher<Any> { environment: DataFetchingEnvironment? ->
            val color = environment?.arguments?.get("color")
            println(color)
            Product.findAll().get(0)
        }
        val schema = HashMap<String, DataFetcher<Any>>()
        schema.put("tryParams", fetcher)
        return schema
    }


    val graphQL = GraphQlBuilder(dataFetcher()).getGraphQl("products.graphqls")
    val result: ExecutionResult = graphQL.execute("""
        {
          tryParams(color: GREEN){
            name
          }
        }
    """.trimIndent())

    println(result.getData<Any>().toString())

}