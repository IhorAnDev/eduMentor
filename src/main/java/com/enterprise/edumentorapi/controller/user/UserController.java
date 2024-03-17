package com.enterprise.edumentorapi.controller.user;

import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.response.user.UserEntityResponse;
import com.enterprise.edumentorapi.security.PersonDetails;
import com.enterprise.edumentorapi.service.user.UserService;
import com.enterprise.edumentorapi.utills.transfer_object.UserTransferObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserTransferObject userTransferObject;

    @GetMapping("/all")
    public ResponseEntity<List<UserEntityResponse>> getAllUsers() {
        return ResponseEntity.ok(userTransferObject.toUserEntityResponseList(userService.getAllUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntityResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userTransferObject.toUserEntityResponse(userService.getUserById(id)));
    }

    @GetMapping("/current-user")
    public ResponseEntity<UserEntityResponse> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        User user = ((PersonDetails) principal).getUser();
        return ResponseEntity.ok(userTransferObject.toUserEntityResponse(user));
    }
}
