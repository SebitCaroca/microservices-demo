package com.example.services.postservice.services;

import com.example.services.postservice.entities.PostEntity;
import com.example.services.postservice.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<PostEntity> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public List<PostEntity> getPostsByPosterId(String posterId) {
        return postRepository.findByPosterId(posterId);
    }

    // identity is verified through Security, so no need to create a separate update method
    public PostEntity createOrUpdatePost(PostEntity post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
