package com.enterprise.edumentorapi.payload.response.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntityResponse {

    private Long courseId;
    private String courseName;
    private String courseDescription;
    private Boolean isEnabled;
}
