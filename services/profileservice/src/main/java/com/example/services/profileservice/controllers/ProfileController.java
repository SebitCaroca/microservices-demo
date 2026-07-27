package com.example.services.profileservice.controllers;

import com.example.services.profileservice.entities.ProfileEntity;
import com.example.services.profileservice.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/me")
    public ResponseEntity<ProfileEntity> getMyProfile(Authentication authentication) {
        String userId = authentication.getName(); // extracts "sub" claim from JWT
        return ResponseEntity.ok(profileService.getOrCreateProfile(userId));
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN') or #userId == authentication.name")
    public ResponseEntity<ProfileEntity> getProfileById(@PathVariable String userId) {
        return ResponseEntity.ok(profileService.getOrCreateProfile(userId));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ProfileEntity>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAll());
    }
}
