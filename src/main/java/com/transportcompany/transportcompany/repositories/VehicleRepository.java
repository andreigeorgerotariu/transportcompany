package com.transportcompany.transportcompany.repositories;

import com.transportcompany.transportcompany.models.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository <Vehicle, Long> {

}
