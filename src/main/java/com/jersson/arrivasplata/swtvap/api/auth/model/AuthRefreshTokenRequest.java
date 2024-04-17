package com.jersson.arrivasplata.swtvap.api.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRefreshTokenRequest {
    private String refreshToken;

}