package com.spring.practice.remote.chunking.autoconfiguration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.FIELD, })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier
public @interface MasterRequestChannel {
}
