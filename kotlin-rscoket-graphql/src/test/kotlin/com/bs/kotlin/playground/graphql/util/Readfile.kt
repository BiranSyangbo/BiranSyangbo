package com.bs.kotlin.playground.graphql.util

import java.io.InputStream

fun readFile(fileName: String?): InputStream? {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(fileName)
}