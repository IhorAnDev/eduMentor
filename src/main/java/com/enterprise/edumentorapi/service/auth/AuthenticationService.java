package com.enterprise.edumentorapi.service.auth;

import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.request.auth.SignInRequest;
import com.enterprise.edumentorapi.payload.request.auth.SignUpRequest;
import com.enterprise.edumentorapi.payload.response.auth.JwtAuthenticationResponse;
import com.enterprise.edumentorapi.payload.response.user.UserEntityResponse;
import com.enterprise.edumentorapi.utills.transfer_object.response_mapper.UserResponseMapper;

public interface AuthenticationService {
    UserEntityResponse signup(SignUpRequest request);

    UserEntityResponse signIn(SignInRequest request);

    UserEntityResponse refreshToken(User user, String accessToken, String refreshToken);
}
