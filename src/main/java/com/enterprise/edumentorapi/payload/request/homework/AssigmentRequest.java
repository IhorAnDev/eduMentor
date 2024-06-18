package com.enterprise.edumentorapi.payload.request.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AssigmentRequest {
    private String assignmentTask;
    private String assigmentUrl;
}
