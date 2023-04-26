package com.transportcompany.transportcompany.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Optional;

@Data
@Entity
@Table(name ="user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;

    public static Optional<User> findById(Long id) {
        return null;
    }

    public static Object save(User updatedUser) {
        return null;
    }
}

