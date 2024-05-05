package com.enterprise.edumentorapi.payload.response.qiuz;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@Component
public class QuizSubmissionResponse {

    private Long id;
    private Long userId;
    private Long quizId;
    private QuizSubmissionDetails details;
    private List<AnswerDetail> answers;


}
