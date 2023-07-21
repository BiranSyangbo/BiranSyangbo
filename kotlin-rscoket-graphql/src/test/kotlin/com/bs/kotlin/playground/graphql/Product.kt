package com.bs.kotlin.playground.graphql

import graphql.GraphQLContext
import graphql.Scalars
import graphql.schema.*
import graphql.schema.FieldCoordinates.coordinates
import graphql.schema.idl.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


fun main() {

    fun registry() {
        var graphQLFieldDefinition = GraphQLFieldDefinition.newFieldDefinition()
                .name("description")
                .type(Scalars.GraphQLString)
                .build()
//        val g = GraphQLCodeRegistry.newCodeRegistry()
//                .
    }

    fun regis(): GraphQLCodeRegistry {
        return GraphQLCodeRegistry.newCodeRegistry()
                .dataFetcher(
                        coordinates("ObjectType", "description"),
                        PropertyDataFetcher<String>("desc"))
                .build()
    }

    fun fetcher(): MutableMap<String, DataFetcher<Any>> {
        val fetcher = DataFetcher<Any> { environment: DataFetchingEnvironment? ->
            val context: GraphQLContext? = environment?.graphQlContext
            val match = environment?.arguments?.get("match")
            Product.findAll()
        }
        val map = HashMap<String, DataFetcher<Any>>()
        map.put("products", fetcher);
        return map
    }

    val graphQL = GraphQlBuilder(fetcher())
            .getGraphQl("products.graphqls");
    val response = graphQL.execute("{\n" +
            "  products {\n" +
            "    name\n" +
            "    launchDate\n" +
            "  }\n" +
            "}")
    val response2 = graphQL.execute("""
        {
          products {
            cost
            description
            launchDate(dateFormat: "yyyy MM dd")
          }
        }
    """)
    println(response.getData<Any>().toString())
    println(response2.getData<Any>().toString())


}

class Product(val id: Int, val desc: String?, val name: String?, val cost: Float?, val tax: Float?, private val launchDate: LocalDateTime) {

    fun getLaunchDate(environment: DataFetchingEnvironment): String {
        val format = environment.getArgument<String>("dateFormat")
        val formatter = DateTimeFormatter.ofPattern(format)
        return launchDate.format(formatter)
    }

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