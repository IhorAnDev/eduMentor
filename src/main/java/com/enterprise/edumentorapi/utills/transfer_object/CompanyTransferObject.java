package com.enterprise.edumentorapi.utills.transfer_object;

import com.enterprise.edumentorapi.entity.Company;
import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.request.company.CompanyRequest;
import com.enterprise.edumentorapi.payload.response.company.CompanyEntityResponse;
import org.springframework.stereotype.Component;

@Component
public class CompanyTransferObject {

    public Company fromRequestCompany(CompanyRequest companyRequest, User user) {
        Company company = new Company();
        company.setCompanyName(companyRequest.getName());
        company.setOwner(user);
        return company;
    }

    public CompanyEntityResponse fromCompany(Company company) {
        CompanyEntityResponse companyEntityResponse = new CompanyEntityResponse();
        companyEntityResponse.setCompanyId(company.getCompanyId());
        companyEntityResponse.setCompanyName(company.getCompanyName());
        companyEntityResponse.setOwnerId(company.getOwner().getUserId());
        return companyEntityResponse;
    }
}
