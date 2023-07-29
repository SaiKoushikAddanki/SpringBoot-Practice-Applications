package com.encryption.demo.encrtptor.utilities.configuration;

import com.encryption.demo.encrtptor.utilities.LoggingRequestRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoggingRequestRequestInterceptor());
    }

    @Bean
    public LoggingRequestRequestInterceptor getLoggingRequestRequestInterceptor() {
        return new LoggingRequestRequestInterceptor();
    }
}
