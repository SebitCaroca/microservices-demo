package com.example.services.postservice.services;

import com.example.services.postservice.entities.PostEntity;
import com.example.services.postservice.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public List<PostEntity> getPostsByPosterId(String posterId) {
        return postRepository.findByPosterId(posterId);
    }

    public PostEntity createPost(PostEntity post) {
        return postRepository.save(post);
    }
}
