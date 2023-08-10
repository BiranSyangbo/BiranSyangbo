package com.bs.kotlin.playground.graphql;

import com.bs.kotlin.playground.graphql.exception.DataFetcherExceptionHandling
import com.bs.kotlin.playground.graphql.util.readFile
import com.github.benmanes.caffeine.cache.Cache
import com.github.benmanes.caffeine.cache.Caffeine
import graphql.ExecutionInput
import graphql.GraphQL
import graphql.execution.preparsed.PreparsedDocumentEntry
import graphql.execution.preparsed.PreparsedDocumentProvider
import graphql.schema.DataFetcher
import graphql.schema.GraphQLSchema
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.SchemaGenerator
import graphql.schema.idl.SchemaParser
import graphql.schema.idl.TypeDefinitionRegistry
import java.math.BigInteger
import java.security.MessageDigest
import java.util.function.Function

class GraphQlBuilder(private val dataFetcher: MutableMap<String, DataFetcher<Any>>) {

    fun getGraphQl(fileName: String): GraphQL {
        val schemaParser: SchemaParser = SchemaParser()
        val register: TypeDefinitionRegistry = schemaParser.parse(readFile(fileName))
        val runtimeWiring = RuntimeWiring.newRuntimeWiring()
                .type("Query") { builder -> builder.dataFetchers(dataFetchers()) }
                .type("Mutation") { builder -> builder.dataFetchers(dataFetchers()) }
                .build()
        val schemaGenerator = SchemaGenerator()
        val graphQLSchema: GraphQLSchema = schemaGenerator.makeExecutableSchema(register, runtimeWiring)
        return GraphQL.newGraphQL(graphQLSchema)
                .preparsedDocumentProvider(cacheQuery())
                .defaultDataFetcherExceptionHandler(DataFetcherExceptionHandling())
                .build()
    }

    private fun dataFetchers(): MutableMap<String, DataFetcher<Any>>? {
        return dataFetcher;
    }

}

fun cacheQuery(): PreparsedDocumentProvider {
    val build = Caffeine.newBuilder().maximumSize(1000)
            .build<String, PreparsedDocumentEntry>()
    return PreparsedDocumentProvider { executionInput: ExecutionInput, parseAndValidateFunction: Function<ExecutionInput, PreparsedDocumentEntry> ->
        val mapCompute: Function<String, PreparsedDocumentEntry> = Function { parseAndValidateFunction.apply(executionInput) }
        val hash: String = md5(executionInput.query)
        build.get(hash, mapCompute)
    }
}


fun md5(input: String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray()))
            .toString(16)
            .padStart(32, '0')
}



