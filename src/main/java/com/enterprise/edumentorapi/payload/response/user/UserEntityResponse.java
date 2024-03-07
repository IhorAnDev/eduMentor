package com.enterprise.edumentorapi.payload.response.user;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntityResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
