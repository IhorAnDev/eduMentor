package com.enterprise.edumentorapi.service.course;

import com.enterprise.edumentorapi.entity.Company;
import com.enterprise.edumentorapi.entity.Course;
import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.request.course.AssignUsersCourseRequest;

import java.util.Set;

public interface CourseService {
    void createCourseCompany(Course course, Long companyId);

    void assignUsersToCourse(Set<User> users, Course course);

    Course getCourseById(Long id);
}
