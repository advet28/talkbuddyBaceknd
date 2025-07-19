package com.example.mbtiquiz.service.mbtiEvaluation;

import com.example.mbtiquiz.model.mbtiEvaluation.Answer;
import com.example.mbtiquiz.model.mbtiEvaluation.MBTIRequest;
import com.example.mbtiquiz.model.mbtiEvaluation.MBTIResponse;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MbtiEvaluationServiceImpl implements MbtiEvaluationService {

    private static final List<String[]> DICHOTOMIES = List.of(
            new String[]{"E", "I"},
            new String[]{"S", "N"},
            new String[]{"T", "F"},
            new String[]{"J", "P"}
    );

    @Override
    public MBTIResponse calculateMBTIType(MBTIRequest request) {
        Map<String, Integer> traitCounts = new HashMap<>();

        // Initialize trait counts
        for (String[] pair : DICHOTOMIES) {
            traitCounts.put(pair[0], 0);
            traitCounts.put(pair[1], 0);
        }

        // Count traits from answers
        for (Answer answer : request.getAnswers()) {
            String trait = answer.getTrait().toUpperCase();
            if (traitCounts.containsKey(trait)) {
                traitCounts.put(trait, traitCounts.get(trait) + 1);
            }
        }

        // Build MBTI type
        StringBuilder mbti = new StringBuilder();

        for (String[] pair : DICHOTOMIES) {
            String trait1 = pair[0];
            String trait2 = pair[1];
            int count1 = traitCounts.get(trait1);
            int count2 = traitCounts.get(trait2);
            mbti.append(count1 >= count2 ? trait1 : trait2);
        }

        String explanation = getShortExplanation(mbti.toString());

        return new MBTIResponse(mbti.toString(), explanation);
    }

    private String getShortExplanation(String mbtiType) {
        return switch (mbtiType) {
            case "INTJ" -> "Strategic, logical, and innovative thinker.";
            case "INFP" -> "Idealistic, empathetic, and driven by values.";
            case "ENTP" -> "Energetic, inventive, and curious debater.";
            case "ISFJ" -> "Loyal, practical, and compassionate protector.";
            // Add more as needed...
            default -> "MBTI type identified.";
        };
    }

}
