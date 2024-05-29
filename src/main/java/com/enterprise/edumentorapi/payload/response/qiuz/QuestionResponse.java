package com.enterprise.edumentorapi.payload.response.qiuz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {

    private Long questionId;
    private String text;
    private Long quizId;
    private List<AnswerOptionResponse> answerOptions;
}
