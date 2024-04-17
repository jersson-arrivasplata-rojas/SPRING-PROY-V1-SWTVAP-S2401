package com.jersson.arrivasplata.swtvap.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.Builder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class JwtUtil {

    private final String SECRET_KEY = "OpgPDWpnCUgzqJLnAqgT78rcAlaSCc5WeRm02abYyCI=";
    private final long EXPIRATION_TIME = 3600_000;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Injected secret key: " + SECRET_KEY);
    }

    private Key getSecretKey() {
        if (SECRET_KEY == null || SECRET_KEY.isEmpty()) {
            throw new IllegalArgumentException("Secret key must not be null or empty");
        }
        byte[] keyBytes = Base64.getDecoder().decode(SECRET_KEY);
        return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();


        Instant iatInstant = Instant.now(); // current time
        Instant expInstant = iatInstant.plusSeconds(EXPIRATION_TIME / 1000); // current time + expiration time in seconds

        Claims claims = Jwts.claims()
                .setSubject(user.getUsername());

        // Get the roles from the user's authorities
        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        claims.put("roles", roles);
        claims.put("iat", iatInstant.getEpochSecond()); // convert to seconds
        claims.put("exp", expInstant.getEpochSecond()); // convert to seconds


        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(iatInstant))
                .setExpiration(Date.from(expInstant))
                .signWith(SignatureAlgorithm.HS256, getSecretKey())
                .compact();
    }

    public Claims extractAllClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            System.out.println("Error parsing token: " + e.getMessage());
            e.printStackTrace(); // Log the stack trace for deeper analysis
            throw e;
        }
    }

    public JwtDecoder jwtDecoder() {
        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withSecretKey((SecretKey) getSecretKey()).build();

        jwtDecoder.setJwtValidator(jwt -> {
            List<String> tokenRoles = jwt.getClaimAsStringList("roles");
            System.out.println("Token roles: " + tokenRoles); // Log the roles in the token
            if (!Collections.disjoint(Arrays.asList("ROLE_ADMIN"), tokenRoles)) {
                return OAuth2TokenValidatorResult.success();
            } else {
                System.out.println("Token does not contain required roles.");
                return OAuth2TokenValidatorResult.failure(new OAuth2Error("invalid_token", "Required roles are not present in the token", null));
            }
        });


        jwtDecoder.setClaimSetConverter(claims -> {

            Map<String, Object> modifiableClaims = new HashMap<>(claims); // Create a modifiable map
            try {
                // Convert 'iat' and 'exp' to Instant
                Date iatDate = (Date) modifiableClaims.get("iat");
                Date expDate = (Date) modifiableClaims.get("exp");
                Instant iatInstant = iatDate.toInstant();
                Instant expInstant = expDate.toInstant();
                modifiableClaims.put("iat", iatInstant);
                modifiableClaims.put("exp", expInstant);

                Object rolesObject = modifiableClaims.get("roles");
                System.out.println("Claims roles: " + rolesObject); // Log the roles in the claims
                if (rolesObject instanceof List) {
                    List<String> roles = (List<String>) rolesObject;
                    List<SimpleGrantedAuthority> authorities = roles.stream()
                            .map(role -> new SimpleGrantedAuthority(role)) // Prefix the role with "ROLE_"
                            .collect(Collectors.toList());
                    modifiableClaims.put("authorities", authorities); // Modify the new map, not the original
                } else {
                    System.out.println("Roles claim is missing or not in expected format: " + rolesObject);
                }
            } catch (Exception e) {
                System.out.println("Failed to process JWT claims: " + e);
                throw e;
            }
            return modifiableClaims;
        });

        return jwtDecoder;
    }

}
