We are using spring-security-oauth2 for validation
Its provide the JwtDecoder which takes tenet-id and Microsoft jwkSet url to validate jwt.
and we use OAuth2TokenValidator provided by oauth2 which uses issuer uri to validate token at auth2.