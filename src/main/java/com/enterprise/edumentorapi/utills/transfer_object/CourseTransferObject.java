package com.enterprise.edumentorapi.utills.transfer_object;

import com.enterprise.edumentorapi.entity.Course;
import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.request.course.AssignUsersCourseRequest;
import com.enterprise.edumentorapi.payload.request.course.CreateCourseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class CourseTransferObject {

    public Course fromRequestCourse(CreateCourseRequest request) {
        Course course = new Course();
        course.setCourseName(request.getName());
        course.setCourseDescription(request.getDescription());
        return course;

    }

}
