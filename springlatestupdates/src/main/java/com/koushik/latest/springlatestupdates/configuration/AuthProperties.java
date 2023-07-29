package com.koushik.latest.springlatestupdates.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Getter
@Component
public class AuthProperties {
    @Value("${auth.jwt.token.secret}")
    private String jwtTokenSecret;
    @Value("${auth.jwt.token.validity.time.millis}")
    private long jwtTokenValidityTimeMillis;
    @Value("${auth.synthetic.id.secret}")
    private String syntheticIdSecret;
    @Value("${auth.login.main.page}")
    private String loginMainPage;
    @Value("${auth.cookie.domain.name}")
    private String domainName;
    @Value("${auth.token.availability.time.seconds}")
    private long authEtbTokenAvailabilityTimeMillis;
    private Duration getAuthEtbTokenAvailabilityTime(){
        return Duration.ofMillis(authEtbTokenAvailabilityTimeMillis);
    }
    public long getJwtTokenValidityTimeSeconds() {
        return this.jwtTokenValidityTimeMillis/1000;
    }

}
