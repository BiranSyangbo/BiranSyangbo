package com.bs.kotlin.playground.graphql;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import graphql.ExecutionInput;
import graphql.execution.preparsed.PreparsedDocumentEntry;
import graphql.execution.preparsed.PreparsedDocumentProvider;

import java.util.function.Function;

class Test {
    private void cache() {
        Cache<String, PreparsedDocumentEntry> cache = Caffeine.newBuilder().maximumSize(10_000).build();

        PreparsedDocumentProvider preparsedCache = new PreparsedDocumentProvider() {
            @Override
            public PreparsedDocumentEntry getDocument(ExecutionInput executionInput, Function<ExecutionInput, PreparsedDocumentEntry> computeFunction) {
                Function<String, PreparsedDocumentEntry> mapCompute = key -> computeFunction.apply(executionInput);
                return cache.get(executionInput.getQuery(), mapCompute);
            }
        };
    }
}