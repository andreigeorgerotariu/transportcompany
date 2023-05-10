package com.transportcompany.transportcompany.services;

import com.transportcompany.transportcompany.models.dtos.OrderDTO;
import com.transportcompany.transportcompany.models.entities.Order;

import java.util.List;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);
    List<OrderDTO> getOrders();
    Order updateOrderById(long orderId, OrderDTO orderDTO) throws Throwable;
    void deleteOrderById(long orderId);

}
