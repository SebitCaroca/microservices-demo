package com.example.services.profileservice.repositories;

import com.example.services.profileservice.entities.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    Optional<ProfileEntity> findByUserId(String userId);
}
