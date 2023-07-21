package com.bs.kotlin.playground.graphql

import graphql.ExecutionResult
import graphql.GraphQL
import graphql.Scalars
import graphql.schema.*
import graphql.schema.GraphQLCodeRegistry.newCodeRegistry
import java.time.LocalDateTime
import java.util.concurrent.CompletableFuture

fun main() {
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


    val mutationQuery = """
        mutation {
          saveProduct(product: {name:"Syangbo Biran"}) {
            id
            name
            cost
          }
        }
    """.trimIndent();
    val promise: CompletableFuture<ExecutionResult> = graphQL.executeAsync { t -> t.query(mutationQuery) }

    promise.thenAccept { t -> println(t.getData<Any>()) }

    promise.join()

}