package com.whisperlink.whisperlink.dao;
import com.whisperlink.whisperlink.models.Post;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("SELECT o FROM Post o WHERE YEAR(o.data) = 2023 AND o.location.city = 'Paris'")
    List<Post> searchPostsByCityAndDate();

}
