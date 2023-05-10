package com.transportcompany.transportcompany.controllers;

import com.transportcompany.transportcompany.models.dtos.UserDTO;
import com.transportcompany.transportcompany.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/api/users/{userid}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable long userId, @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.updateUserById(userId, userDTO));
    }

    @DeleteMapping("/api/users/{userid}")
    public ResponseEntity<Void> deleteUserById(@PathVariable long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }
}

