package com.bs.kotlin.playground.graphql

import com.bs.kotlin.playground.graphql.util.readFile
import graphql.schema.idl.SchemaParser
import graphql.schema.idl.TypeDefinitionRegistry
import graphql.schema.idl.RuntimeWiring
import java.util.function.UnaryOperator
import graphql.schema.idl.TypeRuntimeWiring
import graphql.schema.StaticDataFetcher
import graphql.schema.idl.SchemaGenerator
import graphql.schema.GraphQLSchema
import graphql.GraphQL
import graphql.ExecutionResult
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import java.io.File

fun main() {
    val iputS = readFile("helloworld.graphql")
    val schemaParser = SchemaParser()
    val typeDefinitionRegistry = schemaParser.parse(iputS)
    val runtimeWiring = RuntimeWiring.newRuntimeWiring()
        .type("Query") { builder: TypeRuntimeWiring.Builder ->
            builder.dataFetcher(
                "hello",
                CustomerDataFetcher()
            );
            builder.dataFetcher("message", CustomerDataFetcher())
        }
        .build()
    val schemaGenerator = SchemaGenerator()
    val graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring)
    val graphQL = GraphQL.newGraphQL(graphQLSchema).build()
//    val result = graphQL.execute("{hello}")
    val request = graphQL.execute("{message(\"hi\")}");
//    println(result.getData<Any>().toString())
    println(request.getData<Any>().toString())
}

class CustomerDataFetcher : DataFetcher<String> {
    override fun get(environment: DataFetchingEnvironment?): String {
        return "Hi It's Biran syabngbo"
    }
}


