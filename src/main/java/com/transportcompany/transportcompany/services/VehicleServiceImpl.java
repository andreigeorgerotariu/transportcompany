package com.transportcompany.transportcompany.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transportcompany.transportcompany.models.dtos.VehicleDTO;
import com.transportcompany.transportcompany.models.entities.Vehicle;
import com.transportcompany.transportcompany.repositories.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, ObjectMapper objectMapper) {
        this.vehicleRepository = vehicleRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicleToSave = objectMapper.convertValue(vehicleDTO, Vehicle.class);
        Vehicle savedVehicle = vehicleRepository.save(vehicleToSave);
        log.info("Vehicle created: " + vehicleDTO);
        return objectMapper.convertValue(savedVehicle, VehicleDTO.class);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(vehicle -> objectMapper.convertValue(vehicle, VehicleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO updateVehicleById(long vehicleId, VehicleDTO vehicleDTO) {
        Vehicle existingVehicle = vehicleRepository.findById(vehicleId)
                .orElse(null);
        if (existingVehicle != null) {
            Vehicle updatedVehicle = objectMapper.convertValue(vehicleDTO, Vehicle.class);
            updatedVehicle.setId(existingVehicle.getId());
            Vehicle savedVehicle = vehicleRepository.save(updatedVehicle);
            log.info("Vehicle updated: " + vehicleDTO);
            return objectMapper.convertValue(savedVehicle, VehicleDTO.class);
        }
        return vehicleDTO;
    }

    @Override
    public void deleteVehicleById(long vehicleId) {
        log.info("Vehicle with id " + vehicleId + " was deleted.");
        vehicleRepository.deleteById(vehicleId);
    }
}
