package com.koushik.latest.springlatestupdates.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.LazyResolvingFeatureManager;

@Configuration
public class WebSecurityConfiguration {


    @Bean
    public FeatureManager getFeatureManager() {
        return new LazyResolvingFeatureManager();
    }
}
