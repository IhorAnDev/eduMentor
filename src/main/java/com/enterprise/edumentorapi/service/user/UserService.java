package com.enterprise.edumentorapi.service.user;

import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.request.user.UserUpdateRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(UserUpdateRequest userUpdate, Long id);
    void deleteUser(Long id);
}
