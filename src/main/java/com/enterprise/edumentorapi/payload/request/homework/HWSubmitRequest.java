package com.enterprise.edumentorapi.payload.request.homework;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HWSubmitRequest {
    private HWAnswerRequest homeworkAnswerRequest;
}
