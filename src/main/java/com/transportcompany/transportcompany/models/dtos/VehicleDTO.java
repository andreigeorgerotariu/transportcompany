package com.transportcompany.transportcompany.models.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class VehicleDTO implements Serializable {

    private long id;
    private String vehicleType;
    private int seatCapacity;
}
