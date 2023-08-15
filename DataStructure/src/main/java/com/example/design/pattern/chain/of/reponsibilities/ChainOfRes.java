package com.example.design.pattern.chain.of.reponsibilities;

import com.example.design.pattern.chain.of.reponsibilities.domain.Message;
import com.example.design.pattern.chain.of.reponsibilities.service.EnrichmentStep;
import com.example.design.pattern.chain.of.reponsibilities.service.steps.EnrichmentStepFacade;
import com.example.design.pattern.chain.of.reponsibilities.service.steps.MessageSecurityEnhanceStep;
import com.example.design.pattern.chain.of.reponsibilities.service.steps.ValidateMessageStep;

import java.util.ArrayList;
import java.util.List;

public class ChainOfRes {

    public static void main(String[] args) {
        List<EnrichmentStep> steps = new ArrayList<>();
        steps.add(new ValidateMessageStep());
        steps.add(new MessageSecurityEnhanceStep());
        var message = new EnrichmentStepFacade(steps)
                .enrich(new Message("Hello this is test"));
        System.out.println(message.content());
    }
}
