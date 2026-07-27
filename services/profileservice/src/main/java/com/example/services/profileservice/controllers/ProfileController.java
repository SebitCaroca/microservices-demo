package com.example.services.profileservice.controllers;

import com.example.services.profileservice.entities.ProfileEntity;
import com.example.services.profileservice.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profiles")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN') or #userId == authentication.name") // ADMIN or SELF
    public ResponseEntity<ProfileEntity> getProfileById(@PathVariable String userId) {
        return ResponseEntity.ok(profileService.getOrCreateProfile(userId));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ProfileEntity>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAll());
    }

    // TODO: UpdateMapping
}
