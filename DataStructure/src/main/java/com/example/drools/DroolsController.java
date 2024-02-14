package com.example.drools;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DroolsController {

    private final AccountFiltrationDecoder accountFiltrationDecoder;

    @GetMapping("/api/v1/accounts")
    public String listAccounts(
            @RequestParam(value = "accessibility", defaultValue = "none") String accessibility,
            @RequestParam(value = "service", defaultValue = "default") String service
    ) {
        accountFiltrationDecoder.getAccountFilter(new AccountFiltrationDecoder.AccountParameter(service, accessibility));
        return "Success";

    }

}

