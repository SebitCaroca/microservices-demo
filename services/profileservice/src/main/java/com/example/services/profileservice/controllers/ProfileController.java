package com.example.services.profileservice.controllers;

import com.example.services.profileservice.entities.ProfileEntity;
import com.example.services.profileservice.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/profiles")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ProfileEntity>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAll());
    }

    // This one is fine, it does not expose sensitive data.
    @GetMapping("/id/{id}")
    public ResponseEntity<ProfileEntity> getProfileById(@PathVariable Long id) {
        Optional<ProfileEntity> found = profileService.getProfileById(id);
        return found.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/iam/{iamId}")
    public ResponseEntity<ProfileEntity> getProfileByIamId(@PathVariable String iamId) {
        Optional<ProfileEntity> found = profileService.getProfileByIamId(iamId);
        return found.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProfileEntity> createEmptyProfile(Authentication authentication) {
        String iamId = authentication.getName();
        ProfileEntity newProfile = new ProfileEntity();
        newProfile.setIamId(iamId);
        newProfile.setDisplayName("User_" + iamId.substring(0,8));
        return ResponseEntity.ok(profileService.saveProfile(newProfile));
    }

    // TODO: UpdateMapping
    // ADMINS can update all profiles.
    // USER can only update their own profile.

    // TODO: DeleteMapping
    // ADMINS can delete all profiles.
    // USER can only delete their own profile.
    // For this, just update the poster's displayUsername with "DELETED-{userId}" and
    // empty out their profile information (not the posts).
}
