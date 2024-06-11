package com.enterprise.edumentorapi.payload.response.qiuz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizSubmissionResult {
    private int score;
    private double percentage;
    private boolean passed;

}
