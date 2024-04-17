package com.jersson.arrivasplata.swtvap.api.auth.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BlacklistedToken {

    @Id
    private String token;
    private Instant expiry;

    // Getters and setters...
}
