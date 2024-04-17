package com.jersson.arrivasplata.swtvap.api.auth.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private String name;
    private String username;
    private String email;
    private String password;
}
