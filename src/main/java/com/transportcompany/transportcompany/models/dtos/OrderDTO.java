package com.transportcompany.transportcompany.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class OrderDTO implements Serializable {
    private long orderId;

    @NotNull(message = "Number of seats is required")
    private Integer seatNumber;

    @NotNull(message = "Departure time is required")
    private LocalDateTime timeOfDeparture;

    @NotNull(message = "Arrival time is required")
    private LocalDateTime timeOfArrival;
    private String numberOfSeats;

}
