package com.spring.practice.remote.chunking.autoconfiguration;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier
public @interface MasterRepliesChannel {
}
