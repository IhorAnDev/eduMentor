package com.enterprise.edumentorapi.service.user;

import com.enterprise.edumentorapi.entity.Company;
import com.enterprise.edumentorapi.entity.CompanyStudent;
import com.enterprise.edumentorapi.entity.User;
import com.enterprise.edumentorapi.payload.request.user.UserUpdateRequest;
import com.enterprise.edumentorapi.repository.CompanyRepository;
import com.enterprise.edumentorapi.repository.CompanyStudentRepository;
import com.enterprise.edumentorapi.repository.UserRepository;
import com.enterprise.edumentorapi.security.PersonDetails;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final CompanyStudentRepository companyStudentRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
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
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(UserUpdateRequest userUpdate, Long id) {
        User user = userRepository.findById(id).orElse(null);
        assert user != null;
        user.setFirstName(userUpdate.getFirstName());
        user.setLastName(userUpdate.getLastName());
        return userRepository.save(user);
    }


    @Override
    @Transactional
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        Company ownedCompany = user.getOwnedCompany();

        if (ownedCompany != null) {
            ownedCompany.setOwner(null);
            companyRepository.delete(ownedCompany);
        }

        for (CompanyStudent companyStudent : user.getCompanyStudents()) {
            companyStudent.setStudent(null);
            companyStudentRepository.save(companyStudent);
        }
        userRepository.delete(user);
    }

    @Override
    public Set<User> getUsersByIds(List<Long> userIds) {
        if (userIds == null || userIds.isEmpty()) {
            return null;
        }
        Set<User> users = userIds.stream()
                .map(userRepository::findUserByUserId)
                .collect(Collectors.toSet());
        return users;
    }

}
