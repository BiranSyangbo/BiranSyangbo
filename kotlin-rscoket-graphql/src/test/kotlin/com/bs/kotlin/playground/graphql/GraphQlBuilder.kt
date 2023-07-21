package com.bs.kotlin.playground.graphql;

import com.bs.kotlin.playground.graphql.exception.DataFetcherExceptionHandling
import com.bs.kotlin.playground.graphql.util.readFile
import graphql.GraphQL
import graphql.schema.DataFetcher
import graphql.schema.GraphQLSchema
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import graphql.schema.idl.TypeDefinitionRegistry

class GraphQlBuilder(private val dataFetcher: MutableMap<String, DataFetcher<Any>>) {

    fun getGraphQl(fileName: String): GraphQL {
        val schemaParser: SchemaParser = SchemaParser()
        val register: TypeDefinitionRegistry = schemaParser.parse(readFile(fileName))
        val runtimeWiring = RuntimeWiring.newRuntimeWiring()
                .type("Query") { builder -> builder.dataFetchers(dataFetchers()) }
                .build()
        val schemaGenerator = SchemaGenerator()
        val graphQLSchema: GraphQLSchema = schemaGenerator.makeExecutableSchema(register, runtimeWiring)
        return GraphQL.newGraphQL(graphQLSchema)
                .defaultDataFetcherExceptionHandler(DataFetcherExceptionHandling())
                .build()
    }

    private fun dataFetchers(): MutableMap<String, DataFetcher<Any>>? {
        return dataFetcher;
    }

}



