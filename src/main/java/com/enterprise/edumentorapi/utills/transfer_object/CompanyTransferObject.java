package com.enterprise.edumentorapi.utills.transfer_object;

import com.enterprise.edumentorapi.entity.Company;
import com.enterprise.edumentorapi.entity.CompanyStudent;
import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.request.company.CompanyRequest;
import com.enterprise.edumentorapi.payload.response.company.CompanyEntityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CompanyTransferObject {

    private final UserTransferObject userTransferObject;

    public Company fromRequestCompany(CompanyRequest companyRequest, User user) {
        Company company = new Company();
        company.setCompanyName(companyRequest.getName());
        company.setOwner(user);
        return company;
    }

    public CompanyEntityResponse fromCompany(Company company) {
        CompanyEntityResponse companyEntityResponse = new CompanyEntityResponse();
        List<User> companyStudents = company.getCompanyStudents().stream().map(CompanyStudent::getStudent).toList();
        companyEntityResponse.setCompanyId(company.getCompanyId());
        companyEntityResponse.setCompanyName(company.getCompanyName());
        companyEntityResponse.setOwnerId(company.getOwner().getUserId());
        companyEntityResponse.setCompanyStudents(companyStudents.stream()
                .map(userTransferObject::toUserEntityResponse).toList());
        return companyEntityResponse;
    }

}
