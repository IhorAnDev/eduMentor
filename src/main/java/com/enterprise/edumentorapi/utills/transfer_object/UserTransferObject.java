package com.enterprise.edumentorapi.utills.transfer_object;

import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.response.user.UserEntityResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTransferObject {

    public UserEntityResponse toUserEntityResponse(User user) {
        UserEntityResponse response = new UserEntityResponse();
        response.setId(user.getUserId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setRoles(user.getUserRoles());
        return response;
    }

    public List<UserEntityResponse> toUserEntityResponseList(List<User> users) {
        return users
                .stream()
                .map(this::toUserEntityResponse)
                .toList();
    }
}
