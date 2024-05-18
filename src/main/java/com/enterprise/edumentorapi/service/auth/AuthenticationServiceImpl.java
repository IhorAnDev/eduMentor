package com.enterprise.edumentorapi.service.auth;

import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.request.auth.SignInRequest;
import com.enterprise.edumentorapi.payload.request.auth.SignUpRequest;
import com.enterprise.edumentorapi.payload.request.auth.TokenRefreshRequest;
import com.enterprise.edumentorapi.payload.response.user.UserEntityResponse;
import com.enterprise.edumentorapi.repository.UserRepository;
import com.enterprise.edumentorapi.security.PersonDetails;
import com.enterprise.edumentorapi.service.user.UserService;
import com.enterprise.edumentorapi.utills.transfer_object.response_mapper.UserResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserResponseMapper userResponseMapper;

    @Override
    public UserEntityResponse signup(SignUpRequest request) {
        var user = userService.createUser(request);
        PersonDetails personDetails = new PersonDetails(user);
        var jwt = jwtService.generateToken(personDetails);
        var refreshToken = jwtService.generateRefreshToken(personDetails);
        return userResponseMapper.toUserResponse(user, jwt, refreshToken);
    }

    @Override
    public UserEntityResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        PersonDetails personDetails = new PersonDetails(user);
        var jwt = jwtService.generateToken(personDetails);
        var refreshToken = jwtService.generateRefreshToken(personDetails);

        return userResponseMapper.toUserResponse(user, jwt, refreshToken);
    }

    @Override
    public UserEntityResponse refreshToken(User user, String accessToken, String refreshToken) {
        return userResponseMapper.toUserResponse(user, accessToken, refreshToken);
    }

}