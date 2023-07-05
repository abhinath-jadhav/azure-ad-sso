//package com.azure.sso.first.filter;
//
//import com.auth0.jwk.Jwk;
//import com.auth0.jwk.JwkProvider;
//import com.auth0.jwk.UrlJwkProvider;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.net.URL;
//import java.security.interfaces.RSAPublicKey;
//
////@Component
//public class JwtFilter extends OncePerRequestFilter {
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        JwkProvider provider = null;
//        Jwk jwk = null;
//        Algorithm algorithm = null;
//
//        String authorizationHeader = httpRequest.getHeader("Authorization");
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            String token = authorizationHeader.substring(7);
//            try {
//                DecodedJWT jwt = JWT.decode(token);
//
//                provider =new UrlJwkProvider(new URL("https://login.microsoftonline.com/common/discovery/keys"));
//                jwk = provider.get(jwt.getKeyId());
//                algorithm = Algorithm.RSA256((RSAPublicKey)jwk.getPublicKey(), null);
//                algorithm.verify(jwt);// if the token signature is invalid, the method will throw - SignatureVerificationException
//
//                filterChain.doFilter(request, response);
//            } catch (Exception e) {
//                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            }
//        } else {
//            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        }
//    }
//}
