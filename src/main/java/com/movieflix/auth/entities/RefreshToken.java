package com.movieflix.auth.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;

@Entity
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer tokenId;

    @Column(nullable = false, length = 500)
    @NotBlank(message = "Please provide refresh token!")
    private  String refreshToken;

    @Column(nullable = false)
    private Instant expirationTime;

    @OneToOne
    private  User user;
}
