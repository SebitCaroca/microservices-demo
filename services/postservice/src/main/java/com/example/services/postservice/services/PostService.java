package com.example.services.postservice.services;

import com.example.services.postservice.dtos.PostResponseDto;
import com.example.services.postservice.entities.PostEntity;
import com.example.services.postservice.models.ProfileEntityModel;
import com.example.services.postservice.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final RestTemplate restTemplate;

    // ----------------------------------------------------------------------------------------------------

    public PostResponseDto createPostResponseDto(PostEntity post) {
        // need to fetch displayName from a ProfileEntity, will be done using restTemplate and ProfileEntityModel

        // ProfileController has a way to fetch a Profile through their ID, and their IAM ID.
        // Internally, we'll use the latter.

        String displayName;

        try{
            ProfileEntityModel profile = restTemplate.getForObject(
                    "http://profileservice/api/v1/profiles/iam/" + post.getPosterId(),
                    ProfileEntityModel.class
            );
            displayName = (profile != null) ? profile.getDisplayName() : "Unknown, IAM ID: " + post.getPosterId();
        } catch (Exception e) {
            displayName = "Unknown, IAM ID: " + post.getPosterId();
        }

        return new PostResponseDto(
                post.getId(),
                post.getPosterId(),
                displayName,
                post.getMessage()
        );
    }

    // ----------------------------------------------------------------------------------------------------

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

    // ----------------------------------------------------------------------------------------------------
}
