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

    // this is executed after a successful registering of an account through keycloak
    // so a regular get method isn't really needed...
    public List<ProfileEntity> getAll() {
        return profileRepository.findAll();
    }

    public Optional<ProfileEntity> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    public Optional<ProfileEntity> getProfileByIamId(String iamId) {
        return profileRepository.findByIamId(iamId);
    }

    public ProfileEntity saveProfile(ProfileEntity profile) {
        return profileRepository.save(profile);
    }
}
