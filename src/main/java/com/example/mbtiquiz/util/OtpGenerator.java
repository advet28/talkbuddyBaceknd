package com.example.mbtiquiz.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class OtpGenerator {

    private static final SecureRandom random = new SecureRandom();

    public String generateOtp(int length) {
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            otp.append(random.nextInt(10)); // 0–9
        }
        return otp.toString();
    }
}
