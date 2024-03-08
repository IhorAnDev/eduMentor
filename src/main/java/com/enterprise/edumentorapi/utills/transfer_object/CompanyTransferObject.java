package com.enterprise.edumentorapi.utills.transfer_object;

import com.enterprise.edumentorapi.entity.Company;
import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.request.company.CompanyRequest;
import org.springframework.stereotype.Component;

@Component
public class CompanyTransferObject {

    public Company fromRequestCompany(CompanyRequest companyRequest, User user) {
        Company company = new Company();
        company.setCompanyName(companyRequest.getName());
        company.setOwner(user);
        return company;
    }
}
