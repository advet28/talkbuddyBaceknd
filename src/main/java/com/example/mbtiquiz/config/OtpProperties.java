package com.example.mbtiquiz.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "talkbuddy.otp")
public class OtpProperties {
    private int length;           // Number of digits in OTP
    private int expiryMinutes;    // Expiry time in minutes
}
