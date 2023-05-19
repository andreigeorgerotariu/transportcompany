package com.transportcompany.transportcompany.services;

import com.transportcompany.transportcompany.models.dtos.OrderDTO;
import com.transportcompany.transportcompany.models.entities.Order;

import java.util.List;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
    Order updateOrderById(long orderId, OrderDTO orderDTO);
    void deleteOrderById(long orderId);
}
