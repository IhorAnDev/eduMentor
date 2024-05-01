package com.enterprise.edumentorapi.payload.request.qiuz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerOptionRequest {

    private String text;
    private boolean isCorrect;

}
