package com.example.mbtiquiz.service.mbtiEvaluation;

import com.example.mbtiquiz.model.MBTIRequest;
import com.example.mbtiquiz.model.MBTIResponse;

public interface MbtiEvaluationService {
    MBTIResponse calculateMBTIType(MBTIRequest request);
}
