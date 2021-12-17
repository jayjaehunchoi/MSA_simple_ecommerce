package com.example.userservice.config.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {


    @Value("${token.expiration_time}")
    private String expireDate;

    @Value("${token.secret}")
    private String secretKey;

    public String createToken(Long id) {
        return Jwts.builder()
                .setSubject(String.valueOf(id))
                .setExpiration(new Date(Long.parseLong(expireDate)))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

    }
}
