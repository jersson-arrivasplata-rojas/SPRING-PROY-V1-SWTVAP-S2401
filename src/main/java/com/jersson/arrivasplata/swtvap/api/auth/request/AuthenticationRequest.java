package com.jersson.arrivasplata.swtvap.api.auth.request;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;//Username or Email
    private String password;
}