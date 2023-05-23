package com.transportcompany.transportcompany.services;

import com.transportcompany.transportcompany.models.dtos.VehicleDTO;

import java.util.List;

public interface VehicleService {

    VehicleDTO createVehicle (VehicleDTO vehicleDTO);
    List<VehicleDTO> getAllVehicles();
    VehicleDTO updateVehicleById (long vehicleId, VehicleDTO vehicleDTO);
    void deleteVehicleById (long vehicleId);
}
