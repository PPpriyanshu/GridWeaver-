package com.gridweaver.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

    @Entity
    @Table(name = "users") // 'user' is often a reserved keyword in databases like PostgreSQL
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Username is required")
        @Column(nullable = false, unique = true)
        private String username;

        @Email(message = "Invalid email format")
        @NotBlank(message = "Email is required")
        private String email;

        // Standard Boilerplate: No-args constructor, Getters, and Setters
        public User() {}

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
    }

