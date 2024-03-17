package com.enterprise.edumentorapi.payload.response.company;

import com.enterprise.edumentorapi.payload.response.user.UserEntityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntityResponse {
    private Long companyId;
    private String companyName;
    private Long ownerId;
    private List<UserEntityResponse> companyStudents = new ArrayList<>();
}
