package com.example.mbtiquiz.service.mbtiAssesment;

import com.example.mbtiquiz.model.getQuestions.MBTIQuestion;

import java.util.List;

public interface MbtiAssessmentService {
    List<MBTIQuestion> getAllQuestions();
}
