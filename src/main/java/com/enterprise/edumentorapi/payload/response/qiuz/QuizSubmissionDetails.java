package com.enterprise.edumentorapi.payload.response.qiuz;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuizSubmissionDetails {
    private int score;
    private double percentage;
    private boolean passed;

}
