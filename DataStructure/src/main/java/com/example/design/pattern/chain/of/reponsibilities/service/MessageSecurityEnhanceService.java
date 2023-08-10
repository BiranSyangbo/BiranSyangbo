package com.example.design.pattern.chain.of.reponsibilities.service;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.Optional;

import static java.util.Optional.*;

public class MessageSecurityEnhanceService {

    private final Optional<String> content;


    public MessageSecurityEnhanceService(String content) {
        this.content = of(content);
    }

    public String filter() {
        return content
                .map(StringEscapeUtils::escapeHtml4)
                .map(StringEscapeUtils::escapeJson)
                .map(StringEscapeUtils::escapeEcmaScript)
                .orElse("");
    }
}
