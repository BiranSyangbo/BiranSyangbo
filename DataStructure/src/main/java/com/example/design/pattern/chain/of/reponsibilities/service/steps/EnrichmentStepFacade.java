package com.example.design.pattern.chain.of.reponsibilities.service.steps;

import com.example.design.pattern.chain.of.reponsibilities.domain.Message;
import com.example.design.pattern.chain.of.reponsibilities.service.ChainElement;
import com.example.design.pattern.chain.of.reponsibilities.service.EnrichmentStep;

import java.util.List;

public class EnrichmentStepFacade {

    private EnrichmentStep nextChain;

    public EnrichmentStepFacade(List<EnrichmentStep> steps) {
        this.nextChain = ChainElement.buildChain(steps, new NoOpEnrichmentStep());
    }

    public Message enrich(Message message) {
        return this.nextChain.enrich(message);
    }
}
