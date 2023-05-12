package com.transportcompany.transportcompany.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderId;
    @NotNull
    @Column(name = "seat_number")
    private Integer seatNumber;
    @NotNull
    @Column(name = "departure_time")
    private LocalDateTime timeOfDeparture;
    @NotNull
    @Column(name = "arrival_time")
    private LocalDateTime timeOfArrival;
    private Object numberOfSeats;

}




