package com.gridweaver.entity;

import jakarta.persistence.*;

    @Entity
    @Table(name = "users") // 'user' is often a reserved keyword in databases like PostgreSQL
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

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

