//package com.whisperlink.whisperlink.services;
//import com.whisperlink.whisperlink.dao.UserRepository;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServices {
//    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public User registerUser(User newUser) {
//        if (userRepository.existsByUsername(newUser.getUsername()) || userRepository.existsByEmail(newUser.getEmail())) {
//            throw new RuntimeException("Uporabniško ime ali e-pošta že obstajata.");
//        }
//
//        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
//        newUser.setPassword(encodedPassword);
//
//        return userRepository.save(newUser);
//    }
//}
