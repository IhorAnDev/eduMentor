package com.enterprise.edumentorapi.service.auth;

import com.enterprise.edumentorapi.payload.request.auth.SignInRequest;
import com.enterprise.edumentorapi.payload.request.auth.SignUpRequest;
import com.enterprise.edumentorapi.payload.response.auth.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signIn(SignInRequest request);
}
