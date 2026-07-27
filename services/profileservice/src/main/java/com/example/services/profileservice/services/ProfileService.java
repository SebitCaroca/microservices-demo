package com.example.services.profileservice.services;

import com.example.services.profileservice.entities.ProfileEntity;
import com.example.services.profileservice.repositories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    public Optional<ProfileEntity> getProfile(String userId) {
        return profileRepository.findByUserId(userId);
    }

    public ProfileEntity getOrCreateProfile(String userId) {
        return profileRepository.findByUserId(userId).orElseGet(() -> {
            ProfileEntity profile = new ProfileEntity();
            profile.setUserId(userId);
            profile.setDisplayName("User " + userId);
            return profileRepository.save(profile);
        });
    }

    public List<ProfileEntity> getAll() {
        return profileRepository.findAll();
    }
}
