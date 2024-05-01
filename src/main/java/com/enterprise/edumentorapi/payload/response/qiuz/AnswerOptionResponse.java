package com.enterprise.edumentorapi.payload.response.qiuz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerOptionResponse {

    private Long answerOptionId;
    private String text;
    private boolean isCorrect;
}
