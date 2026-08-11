package com.gridweaver.controller;

import com.gridweaver.entity.User;
import com.gridweaver.service.UserService;
import org.jspecify.annotations.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User saveUser(@Valid @RequestBody User user) {
        return service.saveUser(user);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    // GET one user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @Valid @RequestBody User user) {
        return service.updateUser(id, user);
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}
    
