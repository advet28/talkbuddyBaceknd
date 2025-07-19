package com.example.mbtiquiz.model.mbtiEvaluation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    private int questionId;
    private String trait; // E, I, S, N, T, F, J, P
}
