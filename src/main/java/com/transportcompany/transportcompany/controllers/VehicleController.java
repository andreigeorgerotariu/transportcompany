package com.transportcompany.transportcompany.controllers;

import com.transportcompany.transportcompany.models.dtos.OrderDTO;
import com.transportcompany.transportcompany.models.dtos.VehicleDTO;
import com.transportcompany.transportcompany.models.entities.Vehicle;
import com.transportcompany.transportcompany.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(vehicleService.createVehicle(vehicleDTO));
    }

    @GetMapping
    public ResponseEntity<List <VehicleDTO>>etAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicleById(id);
        return ResponseEntity.noContent().build();
    }
}


