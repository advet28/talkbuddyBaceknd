package com.example.mbtiquiz.model.mbtiEvaluation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MBTIResponse {
    private String mbtiType;
    private String explanation; // Optional: short description
}
