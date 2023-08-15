package com.example.design.pattern.chain.of.reponsibilities.service;

import org.apache.commons.lang3.StringUtils;

public record ValidateMessageService(String content) {

    public boolean filter() {
        return StringUtils.isNotBlank(content);
    }
}
