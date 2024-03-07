package com.enterprise.edumentorapi.service.user;

import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.repository.UserRepository;
import com.enterprise.edumentorapi.security.PersonDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return new PersonDetails(user);
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User updateUser(User user, Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
