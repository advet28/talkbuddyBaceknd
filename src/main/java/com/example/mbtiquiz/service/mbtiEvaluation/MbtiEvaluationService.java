package com.example.mbtiquiz.service.mbtiEvaluation;

import com.example.mbtiquiz.model.mbtiEvaluation.MBTIRequest;
import com.example.mbtiquiz.model.mbtiEvaluation.MBTIResponse;

public interface MbtiEvaluationService {
    MBTIResponse calculateMBTIType(MBTIRequest request);
}
