package com.whisperlink.whisperlink.dao;
import com.whisperlink.whisperlink.models.DateCalendar;
import com.whisperlink.whisperlink.models.Post;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    // Complex query with 2 parameters
    @Query("SELECT o FROM Post o WHERE YEAR(o.date) = :year AND o.location.city = :city")
    List<Post> searchPostsByCityAndDate(@Param("year") int year, @Param("city") String city);

    //Query with 2 models, search by post date and user last name
    @Query("SELECT p FROM Post p JOIN p.user u JOIN p.date d JOIN p.location l WHERE d = :postDate AND u.lastName = :userLName")
    List<Post> findPostsByDateAndUserLastName(@Param("postDate") DateCalendar postDate, @Param("userLName") String userLName);

    @Query("SELECT p FROM Post p " + "JOIN p.user u " + "JOIN p.location l " + "WHERE u.lastName = :userLName " + "AND l.country = :locationCountry " +
            "AND (p.date.year = :startDYear AND p.date.month >= :startDMonth AND p.date.day >= :startDDay) " +
            "AND (p.date.year = :endDYear AND p.date.month <= :endDMonth AND p.date.day <= :endDDay)")
    List<Post> findPostsByUserLastNameAndLocationAndDateRange(
            @Param("userLName") String userLName,
            @Param("locationCountry") String locationCountry,
            @Param("startDYear") int startDYear,
            @Param("startDMonth") int startDMonth,
            @Param("startDDay") int startDDay,
            @Param("endDYear") int endDYear,
            @Param("endDMonth") int endDMonth,
            @Param("endDDay") int endDDay);

}
