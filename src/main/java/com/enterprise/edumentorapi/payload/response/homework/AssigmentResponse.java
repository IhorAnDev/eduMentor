package com.enterprise.edumentorapi.payload.response.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AssigmentResponse {
    private String assignmentTask;
    private String assigmentUrl;
}
