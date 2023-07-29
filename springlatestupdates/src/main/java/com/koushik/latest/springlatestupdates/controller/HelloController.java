package com.koushik.latest.springlatestupdates.controller;

import com.koushik.latest.springlatestupdates.service.Java17FeaturesPractice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

import java.io.FileNotFoundException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HelloController {

    private static final Feature DISCOUNT_APPLIED = new NamedFeature("DISCOUNT_APPLIED");
    private final Java17FeaturesPractice initiatorService;
    @Autowired
    private FeatureManager featureManager;

    @GetMapping("/")
    /**
     *
     */
    public String getWelcomeMessage() throws FileNotFoundException {
        /*if (featureManager.isActive(DISCOUNT_APPLIED)) {
            log.info("DISCOUNT PRICE is applied");
        } else {
            log.info("DISCOUNT NOT applied");
        }*/
        initiatorService.getServiceResponse();
        return "Hello babay";
    }


    @GetMapping("/welcome")
    public String getWelcomeMessage1() {
        return "Welcome";
    }

}
