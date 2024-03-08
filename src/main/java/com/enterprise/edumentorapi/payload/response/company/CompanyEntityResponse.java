package com.enterprise.edumentorapi.payload.response.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntityResponse {
    private Long companyId;
    private String companyName;
    private Long ownerId;
}
