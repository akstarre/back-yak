package com.example.wanderingyak.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {

    private static final SecretKey KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String createToken(String username, String role) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + (1000 * 60 * 60 * 2));

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(KEY, SignatureAlgorithm.HS512)
                .compact();
    }
}