package com.bs.kotlin.playground.dto

import graphql.schema.DataFetchingEnvironment
import java.time.LocalDateTime
import java.util.*


class ProductDto(
    private val name: String,
    private val launchDate: LocalDateTime,
    private val tax: Double,
    private val id: UUID,
    private val description: String,
    private val cost: Double
) {
    fun getLaunchDate(environment: DataFetchingEnvironment): String? {
        val dateFormat = environment.getArgument<String>("dateFormat")
//        return yodaTimeFormatter(launchDate, dateFormat)
        return null;
    }

}