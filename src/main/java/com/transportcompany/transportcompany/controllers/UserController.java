package com.transportcompany.transportcompany.controllers;

import com.transportcompany.transportcompany.models.entities.User;
import com.transportcompany.transportcompany.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/api/clients/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        Optional<User> user;
        user = User.findById(id);
        if (user.isPresent()) {
            updatedUser.setId(id);
            return ResponseEntity.ok((User) User.save(updatedUser));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
