//package com.azure.sso.utils;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.function.Function;
//
//@Component
//public class JwtUtil {
//
//    @Value("${jwt.secret}")
//    private String jwtSecret;
//
//    public static final String AUTHORIZATION_HEADER = "Authorization";
//
//    private String resolveToken(HttpServletRequest request) {
//        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
//        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7);
//        }
//        return null;
//    }
//
//    public String getUserName(HttpServletRequest request) {
//        String token = resolveToken(request);
//        return extractUsername(token);
//    }
//
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody();
//    }
//}
