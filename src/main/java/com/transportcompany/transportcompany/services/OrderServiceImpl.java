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
import java.util.stream.Collectors;

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
        return objectMapper.convertValue(orderSaved, OrderDTO.class);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> objectMapper.convertValue(order, OrderDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public Order updateOrderById(long orderId, OrderDTO orderDTO) {
        Order orderFound = (Order) orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order", "id", orderId));
        orderFound.setNumberOfSeats(orderDTO.getNumberOfSeats());
        orderFound.setTimeOfDeparture(orderDTO.getTimeOfDeparture());
        orderFound.setTimeOfArrival(orderDTO.getTimeOfArrival());
        Order updatedOrder = (Order) orderRepository.save(orderFound);
        return updatedOrder;
    }

    @Override
    public void deleteOrderById(long orderId) {
        orderRepository.deleteById(orderId);
    }
}
