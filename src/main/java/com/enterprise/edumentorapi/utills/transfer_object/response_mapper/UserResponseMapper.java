package com.enterprise.edumentorapi.utills.transfer_object.response_mapper;

import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.response.user.UserEntityResponse;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper {

    public UserEntityResponse toUserResponse(User user, String token) {
        UserEntityResponse response = new UserEntityResponse();
        response.setId(user.getUserId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setRole(user.getUserRole().name());
        response.setToken(token);
        return response;

    }

}
