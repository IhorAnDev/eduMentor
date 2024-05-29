package com.enterprise.edumentorapi.controllers.company;

import com.enterprise.edumentorapi.entity.Company;
import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.enums.UserRole;
import com.enterprise.edumentorapi.payload.request.company.CompanyRequest;
import com.enterprise.edumentorapi.payload.request.company.StudentAssignRequest;
import com.enterprise.edumentorapi.payload.response.company.CompanyEntityResponse;
import com.enterprise.edumentorapi.security.PersonDetails;
import com.enterprise.edumentorapi.service.company.CompanyService;
import com.enterprise.edumentorapi.utills.transfer_object.CompanyTransferObject;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyTransferObject companyTransferObject;
    private final CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<Void> createCompany(@RequestBody CompanyRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof PersonDetails) {
            User user = ((PersonDetails) principal).getUser();
            user.setUserRole(UserRole.ADMIN);
            Company company = companyTransferObject.fromRequestCompany(request, user);
            companyService.createCompany(company);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<CompanyEntityResponse>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();

        return ResponseEntity.ok(companies.stream().map(companyTransferObject::fromCompany).toList());
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyEntityResponse> getCompanyById(@PathVariable Long companyId) {
        Company company = companyService.getCompanyWithCoursesById(companyId);
        return ResponseEntity.ok(companyTransferObject.fromCompany(company));
    }

    @PostMapping("/assign")
    public ResponseEntity<Void> assignUserToCompany(@RequestBody StudentAssignRequest request) {
        companyService.assignUserToCompany(request.getCompanyId(), request.getUserId());
        return ResponseEntity.ok().build();
    }
}
