package com.example.mbtiquiz.service.mbtiAssesment;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.mbtiquiz.model.mbtiAssesment.MBTIQuestion;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class MbtiAssessmentServiceImpl implements MbtiAssessmentService{

    public List<MBTIQuestion> getAllQuestions() {

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getClassLoader().getResourceAsStream("json/mbti-questions.json");
            return mapper.readValue(is, new TypeReference<List<MBTIQuestion>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to load MBTI questions", e);
        }
    }
}


