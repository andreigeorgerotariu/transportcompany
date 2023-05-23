package com.transportcompany.transportcompany.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transportcompany.transportcompany.exceptions.OrderNotFoundException;
import com.transportcompany.transportcompany.models.dtos.OrderDTO;
import com.transportcompany.transportcompany.models.entities.Order;
import com.transportcompany.transportcompany.repositories.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ObjectMapper objectMapper) {
        this.orderRepository = orderRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order orderToSave = objectMapper.convertValue(orderDTO, Order.class);
        Object orderSaved = orderRepository.save(orderToSave);
        log.info("Order created: " + orderDTO);
        return objectMapper.convertValue(orderSaved, OrderDTO.class);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> objectMapper.convertValue(order, OrderDTO.class))
                .toList();
    }

    @Override
    public Order updateOrderById(long orderId, OrderDTO orderDTO) {
        Order orderFound = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order", "id", orderId));
        orderFound.setOrderId(orderDTO.getOrderId());
        orderFound.setSeatNumber(orderDTO.getSeatNumber());
        orderFound.setDepartureTime(orderDTO.getDepartureTime());
        orderFound.setArrivalTime(orderDTO.getArrivalTime());
        Order updatedOrder = orderRepository.save(orderFound);
        log.info("Order updated: " + orderDTO);
        return updatedOrder;
    }

    @Override
    public void deleteOrderById(long orderId) {
        log.info("Order with id " + orderId + " was deleted.");
        orderRepository.deleteById(orderId);
    }
}