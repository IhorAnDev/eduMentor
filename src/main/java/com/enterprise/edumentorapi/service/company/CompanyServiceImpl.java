package com.enterprise.edumentorapi.service.company;

import com.enterprise.edumentorapi.entity.Company;
import com.enterprise.edumentorapi.entity.CompanyStudent;
import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.exceptions.EntityNotFoundException;
import com.enterprise.edumentorapi.repository.CompanyRepository;
import com.enterprise.edumentorapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    @Override
    public void createCompany(Company company) {
        User owner = company.getOwner();
        userRepository.save(owner);
        companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }


    @Override
    public Company getCompanyById(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with id: " + companyId));
    }

    @Override
    public Company getCompanyWithStudentsById(Long id) {
        return companyRepository.findCompanyWithStudentsById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with id: " + id));
    }

    @Override
    public void assignUserToCompany(Long companyId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with id: " + companyId));

        CompanyStudent companyStudent = new CompanyStudent();
        companyStudent.setStudent(user);
        companyStudent.setCompany(company);

        company.getCompanyStudents().add(companyStudent);
        companyRepository.save(company);
    }


}
