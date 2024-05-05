package com.enterprise.edumentorapi.payload.request.qiuz;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class AnswerRequest {

    private Long questionId;
    private Long chosenOptionId;
}
