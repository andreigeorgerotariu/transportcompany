package com.transportcompany.transportcompany.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "seat_number")
    private int seatNumber;
    @Column(name = "departure_time")
    private LocalDateTime departureTime;
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "costumer_order_id")
    private User user;
}