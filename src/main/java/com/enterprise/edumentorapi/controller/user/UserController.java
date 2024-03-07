package com.enterprise.edumentorapi.controller.user;

import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.response.user.UserEntityResponse;
import com.enterprise.edumentorapi.service.user.UserService;
import com.enterprise.edumentorapi.utills.transfer_object.UserTransferObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserTransferObject userTransferObject;

    @RequestMapping("/all")
    public ResponseEntity<List<UserEntityResponse>> getAllUsers() {
        return ResponseEntity.ok(userTransferObject.toUserEntityResponseList(userService.getAllUsers()));
    }
}
