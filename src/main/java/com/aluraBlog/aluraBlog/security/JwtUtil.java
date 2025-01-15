package com.aluraBlog.aluraBlog.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

    private final String secretKey = "mi_clave_secreta"; // Usa una clave secreta fuerte
    private final long expirationTime = 86400000L; // 1 día de expiración en milisegundos

    public String generateToken(String username) {
        return JWT.create()
                .withSubject(username) // El 'subject' del JWT es el usuario
                .withIssuedAt(new Date()) // Fecha de emisión
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime)) // Fecha de expiración
                .sign(Algorithm.HMAC256(secretKey)); // Firma con el secreto
    }

    public boolean validateToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractUsername(String token) {
        return JWT.decode(token).getSubject(); // Extrae el nombre de usuario del token
    }
}

