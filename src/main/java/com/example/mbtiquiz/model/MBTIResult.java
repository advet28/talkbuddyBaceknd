package com.example.mbtiquiz.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "mbti_results")
public class MBTIResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String mbtiType;

    private LocalDateTime submittedAt = LocalDateTime.now();

}
