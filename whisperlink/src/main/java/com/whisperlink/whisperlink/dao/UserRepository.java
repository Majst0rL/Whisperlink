package com.whisperlink.whisperlink.dao;

import com.whisperlink.whisperlink.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
}
