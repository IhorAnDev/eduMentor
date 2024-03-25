package com.enterprise.edumentorapi.service.course;

import com.enterprise.edumentorapi.entity.Company;
import com.enterprise.edumentorapi.entity.Course;
import com.enterprise.edumentorapi.repository.CompanyRepository;
import com.enterprise.edumentorapi.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl  implements CourseService {

    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    @Override
    public void createCourseCompany(Course course, Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with id: " + companyId));
        course.setOfferingCompany(company);
        courseRepository.save(course);
    }

}
