package com.example.mbtiquiz.model.sendOtp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SendOtpResponse {
    private String otp;
    private String message;
}
