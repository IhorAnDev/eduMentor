package com.enterprise.edumentorapi.payload.request.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HWRequest {
    private String title;
    private String description;
    private boolean isMandatory;
    private AssigmentRequest assigmentRequest;
}
