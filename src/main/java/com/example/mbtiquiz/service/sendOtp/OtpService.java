package com.example.mbtiquiz.service.sendOtp;

import com.example.mbtiquiz.model.sendOtp.SendOtpRequest;
import com.example.mbtiquiz.model.sendOtp.SendOtpResponse;

public interface OtpService {
    SendOtpResponse sendOtp(SendOtpRequest request);
}
