package com.example.services.postservice.controllers;

import com.example.services.postservice.dtos.PostResponseDto;
import com.example.services.postservice.entities.PostEntity;
import com.example.services.postservice.services.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // ----------------------------------------------------------------------------------------------------

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAllPosts() {
        return ResponseEntity.ok(
                postService.getAllPosts().stream()
                        .map(postService::createPostResponseDto)
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostEntity> getPostById(@PathVariable Long postId) {
        Optional<PostEntity> found = postService.getPostById(postId);
        return found.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-user/{posterId}")
    public ResponseEntity<List<PostEntity>> getPostsByPosterId(@PathVariable  String posterId) {
        return ResponseEntity.ok(postService.getPostsByPosterId(posterId));
    }

    @PostMapping
    public ResponseEntity<PostEntity> createPost(@Valid @RequestBody PostEntity post, Authentication authentication) {
        post.setId(null);
        post.setPosterId(authentication.getName());
        return ResponseEntity.ok(postService.savePost(post));
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

    // ----------------------------------------------------------------------------------------------------
}
