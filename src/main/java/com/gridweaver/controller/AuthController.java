package com.gridweaver.controller;
import com.gridweaver.dto.LoginRequest;
import com.gridweaver.dto.RegisterRequest;
import com.gridweaver.dto.UserResponse;
import com.gridweaver.entity.User;
import com.gridweaver.service.AuthService;
import jakarta.validation.Valid;
import com.gridweaver.service.JwtService;

import java.util.Map;

import java.util.HashMap;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
private final JwtService jwtService;

public AuthController(AuthService authService, JwtService jwtService) {
    this.authService = authService;
    this.jwtService = jwtService;
}
    
   @PostMapping("/register")
public User register(@Valid @RequestBody RegisterRequest request) {
    return authService.register(request);
}
@PostMapping("/login")
public Map<String, Object> login(@RequestBody LoginRequest request) {

    User user = authService.login(request);

    String token = jwtService.generateToken(user.getEmail());

    Map<String, Object> response = new HashMap<>();

    response.put("message", "Login successful");
    response.put("token", token);
    response.put("user", new UserResponse(
            user.getId(),
            user.getUsername(),
            user.getEmail()
    ));

    return response;
}
}
