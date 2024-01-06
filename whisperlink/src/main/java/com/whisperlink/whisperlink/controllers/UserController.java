package com.whisperlink.whisperlink.controllers;
import com.whisperlink.whisperlink.models.Organization;
import com.whisperlink.whisperlink.models.User;
import com.whisperlink.whisperlink.dao.UserRepository;
import com.whisperlink.whisperlink.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserController(UserRepository userRepository, UserService userService,BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    //GET all users
    @GetMapping("/")
    public List<User> getAllUsers() {return (List<User>) userRepository.findAll();}

    //GET user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Create User
    @PostMapping("/")
    public User createUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    //UPDATE User
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        updatedUser.setId(id);
        userRepository.save(updatedUser);
        return ResponseEntity.ok(updatedUser);
    }

    //DELETE User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //SEARCH by name and last name
    @GetMapping("/search")
    public List<User> findUsersByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    // REGISTER User
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser) {
        // SET role for user
        String userRole = "USER";

        // SET encoded password for user
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);

        User registeredUser = userService.registerUser(newUser, userRole);
        return ResponseEntity.ok(registeredUser);
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.ok("Login successful for user: " + username);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    // GET organizations from user id
//    @GetMapping("/{userId}/organizations")
//    public ResponseEntity<List<Organization>> getUserOrganizations(@PathVariable("userId") Long userId) {
//        List<Organization> organizations = userRepository.findUserOrganizations(userId);
//        return ResponseEntity.ok(organizations);
//    }
}