package com.bs.kotlin.playground.repository;

import com.bs.kotlin.playground.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface TestRepository extends JpaRepository<Test, Long>, QuerydslPredicateExecutor<Test> {
}
`