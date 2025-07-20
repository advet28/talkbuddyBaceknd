package com.example.mbtiquiz.model.sendOtp;

import lombok.Data;

@Data
public class SendOtpRequest {
    private String email;
    private String name;
}
