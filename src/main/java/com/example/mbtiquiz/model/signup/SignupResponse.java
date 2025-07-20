package com.example.mbtiquiz.model.signup;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupResponse {
    private String message;
    private String email;
    private String mbtiType;
}
