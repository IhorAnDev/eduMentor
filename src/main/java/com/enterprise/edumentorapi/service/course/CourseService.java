package com.enterprise.edumentorapi.service.course;

import com.enterprise.edumentorapi.entity.Course;

public interface CourseService {
    void createCourseCompany(Course course, Long companyId);

}
