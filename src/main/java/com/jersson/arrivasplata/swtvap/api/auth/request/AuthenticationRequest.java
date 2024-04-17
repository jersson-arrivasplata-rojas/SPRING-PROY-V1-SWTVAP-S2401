package com.jersson.arrivasplata.swtvap.api.auth.request;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String usernameOrEmail;
    private String password;
}