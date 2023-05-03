package com.transportcompany.transportcompany.repositories;

import com.transportcompany.transportcompany.models.dtos.OrderDTO;
import com.transportcompany.transportcompany.models.entities.Order;
import com.transportcompany.transportcompany.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <User, Long> {
        static Order save(OrderDTO orderToSave) {
        return null;
    }
    }
