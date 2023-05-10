package com.transportcompany.transportcompany.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "vehicle")
public class Vehicle {
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "number_of_seats")
    private String numberOfSeats;

}