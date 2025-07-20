package com.example.mbtiquiz.service.signup;


import com.example.mbtiquiz.model.signup.SignupRequest;
import com.example.mbtiquiz.model.signup.SignupResponse;

public interface UserService {
    SignupResponse registerUser(SignupRequest request);
}
