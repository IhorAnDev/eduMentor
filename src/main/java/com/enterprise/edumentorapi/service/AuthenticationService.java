package com.enterprise.edumentorapi.service;

import com.enterprise.edumentorapi.dao.request.SignInRequest;
import com.enterprise.edumentorapi.dao.request.SignUpRequest;
import com.enterprise.edumentorapi.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signIn(SignInRequest request);
}
