package com.gridweaver.service;

import com.gridweaver.dto.LoginRequest;
import com.gridweaver.dto.RegisterRequest;
import com.gridweaver.entity.User;
import com.gridweaver.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
public AuthService(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder){
    this.userRepository=userRepository;
     this.passwordEncoder = new BCryptPasswordEncoder();
} 
public User register(RegisterRequest request){
    if(userRepository.existsByUsername(request.getUsername())){
        throw new RuntimeException("UserName Already Exist");
    }
    if(userRepository.existsByEmail(request.getEmail())){
        throw new RuntimeException("Email Already Exist");
    }
    User user = new User();
    user.setUsername(request.getUsername());
    user.setEmail(request.getEmail());

    user.setPassword(passwordEncoder.encode(request.getPassword()));
    return userRepository.save(user);
}

 
    public User login(LoginRequest request) {

    User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("Email not found"));

    System.out.println("Email found: " + user.getEmail());
    System.out.println("Stored password: " + user.getPassword());
    System.out.println("Password matches: "
            + passwordEncoder.matches(request.getPassword(), user.getPassword()));

    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
        throw new RuntimeException("Password does not match");
    }

    return user;
}

       



}

