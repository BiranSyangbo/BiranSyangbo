package com.bs.kotlin.playground.graphql

import graphql.ExecutionResult
import graphql.GraphQL
import graphql.GraphQLContext
import graphql.Scalars
import graphql.schema.*
import graphql.schema.GraphQLCodeRegistry.newCodeRegistry
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.CompletableFuture

fun main() {
    readMutationFileFromFile()

}

fun readMutationFileFromFile() {

    fun fetcher(): MutableMap<String, DataFetcher<Any>> {
        val fetcher = DataFetcher<Any> { environment: DataFetchingEnvironment? ->
            val context: GraphQLContext? = environment?.graphQlContext
            val match = environment?.arguments?.get("product") as Map<String, *>
            println(match)
            val product = Product.findAll()[0]
            product.name = match["name"] as String?
            product
        }
        val map = HashMap<String, DataFetcher<Any>>()
        map.put("saveProduct", fetcher);
        return map
    }

    val graphQl = GraphQlBuilder(fetcher()).getGraphQl("products.graphqls")
    val executionResult: ExecutionResult = graphQl.execute(mutationQuery)
    println(executionResult.toSpecification())
}

private fun customFieldInitialization() {
    val productDto = GraphQLInputObjectType.newInputObject()
            .name("ProductDto")
            .field(GraphQLInputObjectField.newInputObjectField()
                    .name("name")
                    .type(Scalars.GraphQLString))
            .field(GraphQLInputObjectField.newInputObjectField()
                    .name("description").type(Scalars.GraphQLString))
            .field(GraphQLInputObjectField.newInputObjectField()
                    .name("tax")
                    .type(Scalars.GraphQLFloat))
            .field(GraphQLInputObjectField.newInputObjectField()
                    .name("cost")
                    .type(Scalars.GraphQLFloat))
            .build();

    val product = GraphQLObjectType.newObject()
            .name("Product")
            .field(GraphQLFieldDefinition.newFieldDefinition()
                    .name("id")
                    .type(Scalars.GraphQLID))
            .field(GraphQLFieldDefinition.newFieldDefinition()
                    .name("name")
                    .type(Scalars.GraphQLString))
            .field(GraphQLFieldDefinition.newFieldDefinition()
                    .name("description").type(Scalars.GraphQLString))
            .field(GraphQLFieldDefinition.newFieldDefinition()
                    .name("tax")
                    .type(Scalars.GraphQLFloat))
            .field(GraphQLFieldDefinition.newFieldDefinition()
                    .name("cost")
                    .type(Scalars.GraphQLFloat))
            .build()

    val graphQlMutation = GraphQLObjectType.newObject()
            .name("saveProduct")
            .field(GraphQLFieldDefinition.newFieldDefinition()
                    .name("saveProduct")
                    .type(product)
                    .argument { t: GraphQLArgument.Builder -> t.name("product").type(productDto) })
            .build();

    val registry = newCodeRegistry()
            .dataFetcher(FieldCoordinates.coordinates("saveProduct", "saveProduct"),
                    DataFetcher { environment ->
                        val get = environment.arguments.get("product")
                        val product = Product(1, "Test", "Biran", 1.3f, 4.5f, LocalDateTime.now())
                        CompletableFuture.completedFuture(product)
                    })
            .build();


    val graphQLSchema = GraphQLSchema.newSchema()
            .query(product)
            .mutation(graphQlMutation)
            .codeRegistry(registry)
            .build();

    val graphQL = GraphQL.newGraphQL(graphQLSchema)
            .build()


    val promise: CompletableFuture<ExecutionResult> = graphQL.executeAsync { t -> t.query(mutationQuery) }

    promise.thenAccept { t -> println(t.getData<Any>()) }

    promise.join()
}

val mutationQuery: String = """
        mutation {
          saveProduct(product: {name:"Lama Biran"}) {
            id
            name
            cost
          }
        }
    """.trimIndent();