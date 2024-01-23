package com.whisperlink.whisperlink.services;
import com.whisperlink.whisperlink.dao.UserRepository;
import com.whisperlink.whisperlink.models.User;

import com.whisperlink.whisperlink.models.UserRole;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

    public User registerUser(User newUser, String role) {
        if (userRepository.existsByUsername(newUser.getUsername()) || userRepository.existsByEmail(newUser.getEmail())) {
            throw new RuntimeException("Username or email already exists.");
        }

        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);

        // Set user role
        newUser.setUserRole(role);

        return userRepository.save(newUser);
    }

    public User registerUser(User newUser, UserRole userRole) {  // Uporabite UserRole namesto String
        if (userRepository.existsByUsername(newUser.getUsername()) || userRepository.existsByEmail(newUser.getEmail())) {
            throw new RuntimeException("Username or email already exists.");
        }

        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);

        // Set user role
        newUser.setUserRole(userRole);

        return userRepository.save(newUser);
    }

    public User updateUserRole(Long userId, UserRole userRole) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Customize the logic based on your requirements
        if (userRole != null) {  // Dodajte preverjanje, da je vloga ne null
            user.setUserRole(userRole);
        } else {
            throw new IllegalArgumentException("Invalid role: " + userRole);
        }

        return userRepository.save(user);
    }

}
