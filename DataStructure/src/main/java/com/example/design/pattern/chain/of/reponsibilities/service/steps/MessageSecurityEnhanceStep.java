package com.example.design.pattern.chain.of.reponsibilities.service.steps;

import com.example.design.pattern.chain.of.reponsibilities.service.MessageSecurityEnhanceService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageSecurityEnhanceStep extends AbstractEnrichmentStep {

    @Override
    public String enrichAndApplyNext(String message) {
        log.info("Started Message Security Enhance Step [{}]", message);
        return new MessageSecurityEnhanceService(message).filter();
    }
}
