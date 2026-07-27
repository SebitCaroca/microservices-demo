package com.example.services.profileservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userId; // for Keycloak

    private String displayName;
    private String avatarUrl;
    private String biography;
}
