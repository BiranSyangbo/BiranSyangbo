package com.example.design.pattern.chain.of.reponsibilities.service;

import java.util.List;

public interface ChainElement<T> {

    void next(T step);

    static <T extends ChainElement<T>> T buildChain(List<T> steps, T defaultElement) {
        if (!steps.isEmpty()) {
            for (int i = 0; i < steps.size(); i++) {
                var current = steps.get(i);
                var next = i < steps.size() - 1 ? steps.get(i + 1) : defaultElement;
                current.next(next);
            }
            return steps.get(0);
        } else {
            return defaultElement;
        }
    }

}
