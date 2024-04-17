package com.jersson.arrivasplata.swtvap.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class ValidateToken {
    public static void validate() {
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX0FETUlOIl0sInN1YiI6Im5ld19lbWFpbCIsImlhdCI6MTcxMjkzOTA0MCwiZXhwIjoxNzEzODAzMDQwfQ.AblQeYAgZkx1JKb8eLIezlhHLFgynS0Qndl8Ubv35VI";
        String secretKey = "I6Ik3fyFkYk6Qaz7IaXnTerAAk8/2DOL4ulGsK1OwJk="; // Reemplaza con la clave secreta real utilizada para firmar el token


        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

        try {
            Claims claims = new JwtUtil().extractAllClaims(jwt);

            System.out.println("JWT is valid.");
            System.out.println("Subject: " + claims.getSubject());
            System.out.println("Expiration: " + claims.getExpiration());

            // Verifica si el token ha expirado
            if (claims.getExpiration().before(new Date())) {
                System.out.println("Token has expired.");
            } else {
                System.out.println("Token is active.");
            }
        } catch (Exception e) {
            System.out.println("Invalid JWT: " + e.getMessage());
        }
    }
}
