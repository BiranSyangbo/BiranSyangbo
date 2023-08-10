package com.example.design.pattern.chain.of.reponsibilities.domain;

public record Message(String content) {
    @Override
    public String content() {
        return content;
    }
}
