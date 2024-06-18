package com.enterprise.edumentorapi.payload.response.homework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HWResponse {

    private Long homeWorkId;
    private String title;
    private String description;
    private Boolean isMandatory;
    private AssigmentResponse assigmentResponse;
}
