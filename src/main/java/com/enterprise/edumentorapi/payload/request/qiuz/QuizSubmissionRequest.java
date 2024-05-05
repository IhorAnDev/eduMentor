package com.enterprise.edumentorapi.payload.request.qiuz;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
public class QuizSubmissionRequest {
    private List<AnswerRequest> answerRequests;
}
