package com.transportcompany.transportcompany.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "vehicle_type")
    private String vehicleType;
    @Column(name = "seat_capacity")
    private int seatCapacity;
}