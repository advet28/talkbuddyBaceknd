package com.example.mbtiquiz.model;// MBTIRequest.java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MBTIRequest {
    private List<Answer> answers;
}
