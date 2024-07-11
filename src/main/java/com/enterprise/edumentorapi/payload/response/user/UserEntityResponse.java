package com.enterprise.edumentorapi.payload.response.user;

import com.enterprise.edumentorapi.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntityResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String token;
    private String refreshToken;
    private Set<UserRole> roles;

}
