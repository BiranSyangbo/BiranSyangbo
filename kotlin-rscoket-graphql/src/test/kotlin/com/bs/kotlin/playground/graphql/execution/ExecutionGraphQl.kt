package com.bs.kotlin.playground.graphql.execution;

import com.bs.kotlin.playground.graphql.exception.DataFetcherExceptionHandling
import graphql.ExecutionResult
import graphql.GraphQL
import graphql.schema.GraphQLObjectType
import graphql.schema.GraphQLSchema

fun main() {
    graphQl()
}

fun graphQl() {
    val graphQLObjectType: GraphQLObjectType = GraphQLObjectType.newObject()
            .build()
    val graphQLSchema: GraphQLSchema = GraphQLSchema.newSchema()
            .build()

    val graphQL = GraphQL.newGraphQL(graphQLSchema)
            .defaultDataFetcherExceptionHandler(DataFetcherExceptionHandling())
            .build();

    val result: ExecutionResult = graphQL.execute("""
        {
            hero{
                name
            }
        }
    """.trimIndent())

    println(result.getData<Any>().toString())
}