package com.azure.sso.first.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

@Configuration
public class Config {

    @Value("${azure.uri.jwk}")
    private String jwkSetUri;
    @Value("${azure.tenet}")
    private String azureTenetId;
    private final String issuerUri = "https://login.microsoftonline.com/bb466cbb-621c-493b-8374-6c8f26dc6a18/v2.0";

    @Bean
    public JwtDecoder jwtDecoder() {
        jwkSetUri = String.format(jwkSetUri, azureTenetId);
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
    }

}
