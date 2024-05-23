package com.enterprise.edumentorapi.utills.transfer_object.response_mapper;

import com.enterprise.edumentorapi.entity.Course;
import com.enterprise.edumentorapi.payload.response.course.CourseEntityResponse;
import org.springframework.stereotype.Component;

@Component
public class CourseResponseMapper {

    public CourseEntityResponse toResponse(Course course) {
        CourseEntityResponse response = new CourseEntityResponse();
        response.setCourseId(course.getCourseId());
        response.setCourseName(course.getCourseName());
        response.setCourseDescription(course.getCourseDescription());
        response.setIsEnabled(course.getIsEnabled());
        return response;
    }
}
