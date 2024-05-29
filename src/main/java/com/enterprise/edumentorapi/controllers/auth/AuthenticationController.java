package com.enterprise.edumentorapi.controllers.auth;

import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.request.auth.SignInRequest;
import com.enterprise.edumentorapi.payload.request.auth.SignUpRequest;
import com.enterprise.edumentorapi.payload.request.auth.TokenRefreshRequest;
import com.enterprise.edumentorapi.payload.response.user.UserEntityResponse;
import com.enterprise.edumentorapi.security.PersonDetails;
import com.enterprise.edumentorapi.service.auth.AuthenticationService;
import com.enterprise.edumentorapi.service.auth.JWTService;
import com.enterprise.edumentorapi.service.user.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JWTService jwtService;
    private final UserServiceImpl userService;


    @PostMapping("/signup")
    public ResponseEntity<UserEntityResponse> signup(@Valid @RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<UserEntityResponse> signIn(@RequestBody SignInRequest request) {
        UserEntityResponse user = authenticationService.signIn(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/refresh")
    public ResponseEntity<UserEntityResponse> refresh(@RequestBody TokenRefreshRequest request) {
        String refreshToken = request.getRefreshToken();
        String userEmail = jwtService.extractUsername(refreshToken);

        UserDetails userDetails = userService.loadUserByUsername(userEmail);
        if (!jwtService.isTokenValid(refreshToken, userDetails)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        User user = ((PersonDetails) userDetails).getUser();
        String newAccessToken = jwtService.generateToken(userDetails);
        String newRefreshToken = jwtService.generateRefreshToken(userDetails);
        return ResponseEntity.ok(authenticationService.refreshToken(user, newAccessToken, newRefreshToken));

    }
}