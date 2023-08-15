package com.example.design.pattern.chain.of.reponsibilities.service;

import org.apache.commons.lang3.StringEscapeUtils;

import static java.util.Optional.of;

public class MessageSecurityEnhanceService {

    private final String content;

    public MessageSecurityEnhanceService(String content) {
        this.content = content;
    }

    public String filter() {
        return of(content)
                .map(StringEscapeUtils::escapeHtml4)
                .map(StringEscapeUtils::escapeJson)
                .map(StringEscapeUtils::escapeEcmaScript)
                .orElse("");
    }
}
