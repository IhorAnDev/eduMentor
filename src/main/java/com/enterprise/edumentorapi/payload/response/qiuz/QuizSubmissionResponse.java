package com.enterprise.edumentorapi.payload.response.qiuz;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
public class QuizSubmissionResponse {
    private Long id;
    private Long userId;
    private Long quizId;
    private QuizSubmissionResult details;
    private List<AnswerDetail> answers;
}
