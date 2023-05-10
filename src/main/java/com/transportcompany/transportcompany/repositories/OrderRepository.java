package com.transportcompany.transportcompany.repositories;

import com.transportcompany.transportcompany.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
