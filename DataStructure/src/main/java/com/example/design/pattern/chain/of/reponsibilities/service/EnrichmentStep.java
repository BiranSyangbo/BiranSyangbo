package com.example.design.pattern.chain.of.reponsibilities.service;


import com.example.design.pattern.chain.of.reponsibilities.domain.Message;

public interface EnrichmentStep extends ChainElement<EnrichmentStep> {

    Message enrich(Message message);
}
