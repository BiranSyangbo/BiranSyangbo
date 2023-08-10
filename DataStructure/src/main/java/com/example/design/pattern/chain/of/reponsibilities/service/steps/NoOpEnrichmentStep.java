package com.example.design.pattern.chain.of.reponsibilities.service.steps;

import com.example.design.pattern.chain.of.reponsibilities.domain.Message;
import com.example.design.pattern.chain.of.reponsibilities.service.EnrichmentStep;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoOpEnrichmentStep implements EnrichmentStep {

    @Override
    public Message enrich(Message message) {
        log.info("Final Message [{}]", message);
        return message;
    }

    @Override
    public void next(EnrichmentStep next) {

    }
}
