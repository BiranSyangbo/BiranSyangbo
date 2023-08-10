package com.example.design.pattern.chain.of.reponsibilities.service;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class ValidateMessageService {

    private final String content;

    public ValidateMessageService(String content) {
        this.content = content;
    }

    public boolean filter() {
        return StringUtils.isNotBlank(content);
    }
}
