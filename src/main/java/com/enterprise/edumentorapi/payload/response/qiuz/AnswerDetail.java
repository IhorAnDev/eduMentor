package com.enterprise.edumentorapi.payload.response.qiuz;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerDetail {
    private Long questionId;
    private Long chosenOptionId;
    private boolean correct;
    private String explanation;
}
