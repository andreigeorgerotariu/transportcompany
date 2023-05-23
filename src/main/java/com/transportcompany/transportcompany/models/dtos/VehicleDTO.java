package com.transportcompany.transportcompany.models.dtos;

import lombok.Data;

@Data
public class VehicleDTO {
    private long id;
    private String vehicleType;
    private int seatCapacity;
}
