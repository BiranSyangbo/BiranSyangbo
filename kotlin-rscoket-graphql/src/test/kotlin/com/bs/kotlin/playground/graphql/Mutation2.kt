package com.bs.kotlin.playground.graphql

import graphql.GraphQL
import graphql.Scalars
import graphql.schema.*
import graphql.schema.GraphQLCodeRegistry.newCodeRegistry

fun main() {
    val productDto = GraphQLInputObjectType.newInputObject()
            .name("ProductDto")
            .field(GraphQLInputObjectField.newInputObjectField()
                    .name("name")
                    .type(Scalars.GraphQLString))
            .field(GraphQLInputObjectField.newInputObjectField()
                    .name("description")
                    .type(Scalars.GraphQLString))
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
                    .name("name")
                    .type(Scalars.GraphQLString))
            .field(GraphQLFieldDefinition.newFieldDefinition()
                    .name("description")
                    .type(Scalars.GraphQLString))
            .field(GraphQLFieldDefinition.newFieldDefinition()
                    .name("tax")
                    .type(Scalars.GraphQLFloat))
            .field(GraphQLFieldDefinition.newFieldDefinition()
                    .name("cost")
                    .type(Scalars.GraphQLFloat))
            .build();

    val graphQlMutation = GraphQLObjectType.newObject()
            .name("saveProduct")
            .field(GraphQLFieldDefinition.newFieldDefinition()
                    .name("saveProduct")
                    .type(product)
                    .argument { builder -> builder.name("product").type(productDto) })
            .build();

    val registry = newCodeRegistry()
            .dataFetcher(FieldCoordinates.coordinates("saveProduct", "saveProduct"),
                    DataFetcher { environment -> println(environment.arguments.get("product")) })
            .build();

    var graphQLSchema = GraphQLSchema.newSchema()
            .query(product)
            .mutation(graphQlMutation)
            .codeRegistry(registry)
            .build();

    var graphQL = GraphQL.newGraphQL(graphQLSchema)
            .build();

    var result = graphQL.execute("""
            mutation {
              saveProduct(product: {name:"Syangbo Biran"}) {
                name
                description
                tax
                cost
              }
            }
        """.trimIndent());

}