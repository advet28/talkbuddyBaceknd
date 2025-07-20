package com.example.mbtiquiz.controller;

import com.example.mbtiquiz.model.mbtiEvaluation.MBTIRequest;
import com.example.mbtiquiz.model.mbtiEvaluation.MBTIResponse;
import com.example.mbtiquiz.model.mbtiAssesment.MBTIQuestion;


import com.example.mbtiquiz.model.sendOtp.SendOtpRequest;
import com.example.mbtiquiz.model.sendOtp.SendOtpResponse;
import com.example.mbtiquiz.model.signup.SignupRequest;
import com.example.mbtiquiz.model.signup.SignupResponse;
import com.example.mbtiquiz.service.mbtiAssesment.MbtiAssessmentService;

import com.example.mbtiquiz.service.mbtiEvaluation.MbtiEvaluationService;
import com.example.mbtiquiz.service.sendOtp.OtpService;
import com.example.mbtiquiz.service.signup.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mbti")
public class MBTIController {

    @Autowired
    private MbtiAssessmentService mbtiAssessmentService;

    @Autowired
    private MbtiEvaluationService mbtiEvaluationService;

    @Autowired
    private OtpService otpService;

    @Autowired
    private UserService userService;

    // Endpoint 1 - Fetch MBTI Questions
    @GetMapping("/questions")
    public List<MBTIQuestion> getQuestions() {
        return mbtiAssessmentService.getAllQuestions();
    }

    // Endpoint 2 - Submit Answers and Get MBTI Result
    @PostMapping("/evaluation")
    public ResponseEntity<MBTIResponse> getMBTIResult(@RequestBody MBTIRequest request) {
        MBTIResponse result = mbtiEvaluationService.calculateMBTIType(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/verifyMail")
    public ResponseEntity<SendOtpResponse> sendOtp(@RequestBody SendOtpRequest request) {
        SendOtpResponse response = otpService.sendOtp(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> registerUser(@RequestBody SignupRequest signUpRequest) {
        SignupResponse savedUser = userService.registerUser(signUpRequest);
        return ResponseEntity.ok(savedUser);
    }
}
