package com.enterprise.edumentorapi.payload.request.company;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAssignRequest {

    private Long companyId;
    private Long userId;
}
