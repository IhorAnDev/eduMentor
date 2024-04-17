package com.enterprise.edumentorapi.service.course;

import com.enterprise.edumentorapi.entity.Company;
import com.enterprise.edumentorapi.entity.Course;
import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.repository.CompanyRepository;
import com.enterprise.edumentorapi.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;

    @Override
    public void createCourseCompany(Course course, Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with id: " + companyId));
        course.setOfferingCompany(company);
        courseRepository.save(course);
    }

    @Override
    public void assignUsersToCourse(Set<User> users, Course course) {
        course.setInvitedStudents(users);
        courseRepository.save(course);
    }


    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + id));
    }

}

