package com.example.services.postservice.controllers;

import com.example.services.postservice.entities.PostEntity;
import com.example.services.postservice.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/by-user/{userId}")
    public ResponseEntity<List<PostEntity>> getPostsByUser(@PathVariable  String userId) {
        return ResponseEntity.ok(postService.getPostsByPosterId(userId));
    }

    @PostMapping("/create-post")
    public ResponseEntity<PostEntity> createPost(@RequestBody PostEntity post) {
        return ResponseEntity.ok(postService.createOrUpdatePost(post));
    }

    // TODO: UpdateMapping

    // TODO: implement security here to apply the rules:
    // posts can only be deleted by the poster creator, or an admin.
    // an admin can delete any post, even those written by other admins.
    // rn anyone can delete so be careful
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}
