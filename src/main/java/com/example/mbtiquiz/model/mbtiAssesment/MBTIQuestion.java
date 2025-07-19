package com.example.mbtiquiz.model.mbtiAssesment;

import lombok.Data;

@Data
public class MBTIQuestion {
    private int id;
    private String text;
    private Option optionA;
    private Option optionB;
    private String dichotomy;
}


