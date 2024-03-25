package com.enterprise.edumentorapi.payload.request.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourseRequest {
    private String name;
    private String description;
    private Long companyId;

}
