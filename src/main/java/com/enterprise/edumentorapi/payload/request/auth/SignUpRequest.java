package com.enterprise.edumentorapi.payload.request.auth;

import com.enterprise.edumentorapi.anotations.PasswordMatches;
import com.enterprise.edumentorapi.anotations.ValidEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@PasswordMatches
public class SignUpRequest {

    @NotEmpty(message = "Username is required")
    private String firstName;
    private String lastName;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is required")
    @ValidEmail
    private String email;

    @NotEmpty(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    private String confirmPassword;

}

