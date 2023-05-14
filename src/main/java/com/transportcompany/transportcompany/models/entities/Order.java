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
    @Column(name = "number_of_seats", columnDefinition = "INT")
    private Integer numberOfSeats;

    @Column(name = "departure_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime timeOfDeparture;

    @Column(name = "arrival_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime timeOfArrival;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "costumer_order_id")
    private User user;
}





