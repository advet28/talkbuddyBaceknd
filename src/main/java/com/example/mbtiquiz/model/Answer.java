package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor       // No-arg constructor
@AllArgsConstructor      // All-args constructor
@Builder
public class Answer {
    private int questionId;
    private String selectedOption; // "A" or "B"
}
