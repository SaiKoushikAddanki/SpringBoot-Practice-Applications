package com.koushik.latest.springlatestupdates.jwt.auth;

import com.koushik.latest.springlatestupdates.configuration.AuthProperties;
import com.koushik.latest.springlatestupdates.service.TokenInvalidationService;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.Key;

@Slf4j
@Component
public class JwtHandler {
    private static final long COOKIE_MAX_REMOVAL = 0L;
    private static final String ISSUER = "MAP";
    private final JwtMapper jwtMapper;
    private final TokenInvalidationService tokenInvalidationService;
    private final Key key;
    private final AuthProperties authProperties;

    public JwtHandler(AuthProperties authProperties, JwtMapper jwtMapper, TokenInvalidationService tokenInvalidationService) {

        this.authProperties = authProperties;
        this.jwtMapper = jwtMapper;
        byte[] keyBytes = Decoders.BASE64.decode(authProperties.getJwtTokenSecret());
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.tokenInvalidationService = tokenInvalidationService;
    }


}
