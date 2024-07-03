package com.enterprise.edumentorapi.utills;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.enterprise.edumentorapi.security.PersonDetails;
import com.enterprise.edumentorapi.entity.User;

public class SecurityUtils {

    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof PersonDetails) {
            return ((PersonDetails) authentication.getPrincipal()).getUser();
        }
        throw new IllegalStateException("User not authenticated");
    }
}