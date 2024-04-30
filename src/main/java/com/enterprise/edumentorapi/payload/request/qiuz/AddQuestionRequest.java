package com.enterprise.edumentorapi.payload.request.qiuz;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddQuestionRequest {
    private String text;
}
