package com.pacto.teste_tecnico.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.pacto.teste_tecnico.domain.user.Users;

@Service
public class TokenService {

    @Value("${jwt.secret-key}")
    private String secret;

    public String generateToken(Users user) {
        try {
            return JWT.create().withIssuer("pacto-api").withSubject(user.getEmail()).withExpiresAt(genExpirationDate())
                    .sign(Algorithm.HMAC256(secret));

        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token JWT", e);
        }
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validateToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(secret)).withIssuer("pacto-api").build().verify(token).getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }

}
