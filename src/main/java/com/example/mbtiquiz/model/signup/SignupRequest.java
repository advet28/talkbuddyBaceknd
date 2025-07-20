package com.example.mbtiquiz.model.signup;

import lombok.Data;

@Data
public class SignupRequest {
    private String fullName;
    private String email;
    private String password;
    private String mbtiType;
}
