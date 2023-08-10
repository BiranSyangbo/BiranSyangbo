package com.example.design.pattern.chain.of.reponsibilities.service.steps;

import com.example.design.pattern.chain.of.reponsibilities.domain.Message;
import com.example.design.pattern.chain.of.reponsibilities.service.EnrichmentStep;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

@Slf4j
public abstract class AbstractEnrichmentStep implements EnrichmentStep {

    private EnrichmentStep next;

    @Override
    public void next(EnrichmentStep step) {
        this.next = step;
    }

    @Override
    public Message enrich(Message message) {
        return Optional.of(message)
                .map(Message::content)
                .map(this::enrichAndApplyNext)
                .filter(StringUtils::isBlank)
                .map(Message::new)
                .orElse(next.enrich(message));
    }

    public abstract String enrichAndApplyNext(String message);
}
