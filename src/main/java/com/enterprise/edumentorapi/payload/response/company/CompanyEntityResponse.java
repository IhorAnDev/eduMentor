package com.enterprise.edumentorapi.payload.response.company;

import com.enterprise.edumentorapi.payload.response.course.CourseEntityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntityResponse {
    private Long companyId;
    private String companyName;
    private Long ownerId;
    private List<CourseEntityResponse> companyCourses;
}
