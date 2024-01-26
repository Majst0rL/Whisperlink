package com.whisperlink.whisperlink.dao;

import com.whisperlink.whisperlink.models.DateCalendar;
import com.whisperlink.whisperlink.models.Organization;
import com.whisperlink.whisperlink.models.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    // Complex query with 2 parameters
    @Query("SELECT u FROM User u WHERE u.firstName = :firstName AND u.lastName = :lastName")
    List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

//    @Query("SELECT u FROM User u " +
//            "JOIN u.birthDate dc " +
//            "JOIN u.post p " +
//            "WHERE dc.id = :dateCalendarId " +
//            "AND p.id = :postId")
//    List<User> findUsersByPosts_IdAndBirthDate_Id(Long postId, Long dateCalendarId);
//


    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);


    boolean existsByPassword(String password);
}
