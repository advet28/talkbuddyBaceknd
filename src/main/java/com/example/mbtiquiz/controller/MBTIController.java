package com.example.mbtiquiz.controller;

import com.example.mbtiquiz.model.MBTIRequest;
import com.example.mbtiquiz.model.MBTIResponse;
import com.example.mbtiquiz.model.getQuestions.MBTIQuestion;



import com.example.mbtiquiz.service.mbtiAssesment.MbtiAssessmentService;

import com.example.mbtiquiz.service.mbtiEvaluation.MbtiEvaluationService;
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
}
