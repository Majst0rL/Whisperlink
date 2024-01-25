package com.whisperlink.whisperlink.services;
import com.whisperlink.whisperlink.dao.UserRepository;
import com.whisperlink.whisperlink.models.User;

import com.whisperlink.whisperlink.models.UserRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );
    }

    public User registerUser(User newUser, UserRole userRole) {
        // Set user role
        newUser.setUserRole(userRole);

        return userRepository.save(newUser);
    }


    public User updateUserRole(Long userId, UserRole userRole) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Customize the logic based on your requirements
        if (userRole != null) {
            user.setUserRole(userRole);
        } else {
            throw new IllegalArgumentException("Invalid role: " + userRole);
        }

        return userRepository.save(user);
    }

}
