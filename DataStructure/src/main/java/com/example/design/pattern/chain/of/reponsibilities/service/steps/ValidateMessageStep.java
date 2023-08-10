package com.example.design.pattern.chain.of.reponsibilities.service.steps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidateMessageStep extends AbstractEnrichmentStep {

    @Override
    public String enrichAndApplyNext(String message) {
        log.info("Started Validate Message Step [{}]", message);
        return message;
    }

}

