package com.gridweaver.controller;

import com.gridweaver.entity.User;
import com.gridweaver.service.UserService;
import org.jspecify.annotations.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
    @PutMapping("/{id}")
    
    public User updateUser(@PathVariable Long id, @RequestBody @NonNull User user){
        user.setId(id);

        
        return service.saveUser(user);
        
    }
    
}