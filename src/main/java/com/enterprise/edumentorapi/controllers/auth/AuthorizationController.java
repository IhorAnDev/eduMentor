package com.enterprise.edumentorapi.controllers.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resource")
@RequiredArgsConstructor
public class AuthorizationController {
    @GetMapping("/hello")
    @Secured("ADMIN")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Here are your resources");
    }
}