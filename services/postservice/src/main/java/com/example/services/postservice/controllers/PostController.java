package com.example.services.postservice.controllers;

import com.example.services.postservice.entities.PostEntity;
import com.example.services.postservice.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostEntity>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/user")
    public ResponseEntity<List<PostEntity>> getPostsByUser(String userId) {
        return ResponseEntity.ok(postService.getPostsByPosterId(userId));
    }

    @PostMapping("/create-post")
    public ResponseEntity<PostEntity> createPost(@RequestBody PostEntity post) {
        return ResponseEntity.ok(postService.createPost(post));
    }
}
