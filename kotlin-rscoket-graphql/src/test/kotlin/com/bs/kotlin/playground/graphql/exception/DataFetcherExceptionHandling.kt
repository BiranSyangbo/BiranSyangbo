package com.bs.kotlin.playground.graphql.exception

import graphql.ExceptionWhileDataFetching
import graphql.execution.DataFetcherExceptionHandler
import graphql.execution.DataFetcherExceptionHandlerParameters
import graphql.execution.DataFetcherExceptionHandlerResult
import graphql.execution.ResultPath
import graphql.language.SourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.CompletableFuture


class DataFetcherExceptionHandling : DataFetcherExceptionHandler {

    override fun handleException(handlerParameters: DataFetcherExceptionHandlerParameters): CompletableFuture<DataFetcherExceptionHandlerResult> {
        val exception = handlerParameters.exception
        val sourceLocation: SourceLocation = handlerParameters.sourceLocation
        val path: ResultPath = handlerParameters.path
        val error = ExceptionWhileDataFetching(path, exception, sourceLocation)
        log.error("Error: ", error)
        val dataFetcherExceptionHandler = DataFetcherExceptionHandlerResult.newResult().error(error).build()
        return CompletableFuture.completedFuture(dataFetcherExceptionHandler);
    }

    companion object {
        var log: Logger = LoggerFactory.getLogger(DataFetcherExceptionHandling::class.java);
    }
}


