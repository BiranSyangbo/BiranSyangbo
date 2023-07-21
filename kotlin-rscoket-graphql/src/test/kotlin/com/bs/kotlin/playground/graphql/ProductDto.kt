package com.bs.kotlin.playground.graphql

import java.time.LocalDateTime
import graphql.schema.DataFetchingEnvironment
import java.time.format.DateTimeFormatter

class ProductDto(val id: Long, val name: String, val description: String, val cost: Double, val tax: Double, val launchDate: LocalDateTime) {
    fun getLaunchDate(environment: DataFetchingEnvironment): String {
        val dateFormat = environment.getArgument<String>("dateFormat")
        return launchDate.format(DateTimeFormatter.ofPattern(dateFormat))
    }
}