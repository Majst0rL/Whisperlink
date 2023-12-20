package com.whisperlink.whisperlink.dao;

import com.whisperlink.whisperlink.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
