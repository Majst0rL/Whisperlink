package com.whisperlink.whisperlink.dao;
import com.whisperlink.whisperlink.models.Post;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    // Complex query with 2 parameters
    @Query("SELECT o FROM Post o WHERE YEAR(o.date) = :year AND o.location.city = :city")
    List<Post> searchPostsByCityAndDate(@Param("year") int year, @Param("city") String city);

}
