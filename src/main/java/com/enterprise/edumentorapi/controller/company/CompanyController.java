package com.enterprise.edumentorapi.controller.company;

import com.enterprise.edumentorapi.entity.Company;
import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.request.company.CompanyRequest;
import com.enterprise.edumentorapi.payload.response.company.CompanyEntityResponse;
import com.enterprise.edumentorapi.security.PersonDetails;
import com.enterprise.edumentorapi.service.company.CompanyService;
import com.enterprise.edumentorapi.utills.transfer_object.CompanyTransferObject;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyTransferObject companyTransferObject;
    private final CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<CompanyEntityResponse> createCompany(@RequestBody CompanyRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof PersonDetails) {
            User user = ((PersonDetails) principal).getUser();
            Company company = companyTransferObject.fromRequestCompany(request, user);
            companyService.createCompany(company);
            return ResponseEntity.ok(companyTransferObject.fromCompany(company));
        }
        return ResponseEntity.badRequest().build();
    }
}
