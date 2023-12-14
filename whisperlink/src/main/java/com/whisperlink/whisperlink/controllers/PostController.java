package com.whisperlink.whisperlink.controllers;
import com.whisperlink.whisperlink.dao.PostRepository;
import com.whisperlink.whisperlink.models.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;

    @Autowired
    public postController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // GET for all
    @GetMapping
    public ResponseEntity<List<Post>> allPosts() {
        List<Post> posts = postRepository.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<Post> postByID(@PathVariable Long id) {
        Optional<Post> posts = postRepository.findById(id);
        return objava.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST add
    @PostMapping
    public ResponseEntity<Post> addPost(@RequestBody Post newPost) {
        Post savedPost = postRepository.save(newPost);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Objava updatedPost) {
        if (postRepository.existsById(id)) {
            updatedPost.setId(id);
            Objava upPost = postRepository.save(updatedPost);
            return new ResponseEntity<>(upPost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE post
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (objavaRepository.existsById(id)) {
            objavaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
