package model;

import java.util.Map;

public class Question {
    private int id;
    private String text;
    private Map<String, Option> options; // "A" or "B"

    private String dichotomy;

    public static class Option {
        private String text;
        private String trait;

    }

    // Getters and setters
}
