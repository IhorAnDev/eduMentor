package com.enterprise.edumentorapi.service.company;

import com.enterprise.edumentorapi.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final CompanyRepository companyRepository;

}
