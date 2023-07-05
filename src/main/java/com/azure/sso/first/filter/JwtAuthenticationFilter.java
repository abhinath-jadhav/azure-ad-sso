package com.azure.sso.first.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${azure.uri.issuer}")
    private String issuerUri;

    @Value("${azure.tenet}")
    private String azureTenetId;

    @Autowired
    private JwtDecoder jwtDecoder;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;


        String authorizationHeader = httpRequest.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

            String token = authorizationHeader.substring(7);
            try {
                // Decode and validate the token using a JWT decoder
                Jwt jwt = jwtDecoder.decode(token);

                // Validate the token using the validator
                issuerUri = String.format(issuerUri, azureTenetId);
                OAuth2TokenValidator<Jwt> validator = JwtValidators.createDefaultWithIssuer(issuerUri);
                OAuth2TokenValidatorResult result = validator.validate(jwt);

                // If the token is not valid, throw an exception
                if (result.hasErrors()) {
                    throw new JwtException("Token validation failed");
                }

                filterChain.doFilter(request, response);
            } catch (Exception e) {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

}
