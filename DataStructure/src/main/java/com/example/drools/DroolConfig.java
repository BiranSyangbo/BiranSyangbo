package com.example.drools;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DroolConfig {

    @Value("${corpay.accounts.transaction.filtration-rules-file-path:rules/hbtf-account-filtration-rules.xlsx}")
    private  String mccCodesRulesFile;
    private static final KieServices kieServices = KieServices.Factory.get();

    @Bean
    public KieContainer kieContainer() {
        Resource dt = ResourceFactory.newClassPathResource(mccCodesRulesFile, getClass());
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem().write(dt);
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }


}
