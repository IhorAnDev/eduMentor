package com.enterprise.edumentorapi.payload.request.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseRequest {

    private Long courseId;
    private String courseName;
    private String courseDescription;
    private Boolean isEnabled;
    private String imageUrl;
}
