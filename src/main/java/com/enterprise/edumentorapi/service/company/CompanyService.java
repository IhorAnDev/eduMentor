package com.enterprise.edumentorapi.service.company;

import com.enterprise.edumentorapi.entity.Company;
import com.enterprise.edumentorapi.entity.User;

import java.util.List;

public interface CompanyService{
    void createCompany(Company company);

    void assignUserToCompany(Long companyId,Long userId);

    List<Company> getAllCompanies();

    Company getCompanyWithStudentsById(Long id);

    Company getCompanyById(Long companyId);
}
