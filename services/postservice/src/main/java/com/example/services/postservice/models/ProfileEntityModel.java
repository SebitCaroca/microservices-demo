package com.example.services.postservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileEntityModel {
    private Long id;
    private String iamId; // for Keycloak
    private String displayName;
    private String avatarUrl;
    private String biography;
}
