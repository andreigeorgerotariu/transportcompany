package com.transportcompany.transportcompany.controllers;

import com.transportcompany.transportcompany.models.dtos.UserDTO;
import com.transportcompany.transportcompany.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.cert.Extension;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users")
    public  ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @GetMapping("/api/users")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/api/users/{userid}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUserById(userId, userDTO));
    }
    @DeleteMapping("/api/users/{id}")
    public void deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
    }
        }

