package com.example.services.postservice.repositories;

import com.example.services.postservice.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByPosterId(String posterId);
}
