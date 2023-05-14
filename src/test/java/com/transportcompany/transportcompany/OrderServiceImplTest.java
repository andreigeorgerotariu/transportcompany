package com.transportcompany.transportcompany;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transportcompany.transportcompany.models.dtos.OrderDTO;
import com.transportcompany.transportcompany.models.entities.Order;
import com.transportcompany.transportcompany.repositories.OrderRepository;
import com.transportcompany.transportcompany.services.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateOrder() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setNumberOfSeats(2);
        orderDTO.setTimeOfDeparture(LocalDateTime.of(2023, 5, 15, 12, 0));
        orderDTO.setTimeOfArrival(LocalDateTime.of(2023, 5, 15, 15, 0));

        Order order = new Order();
        order.setNumberOfSeats(2);
        order.setTimeOfDeparture(LocalDateTime.of(2023, 5, 15, 12, 0));
        order.setTimeOfArrival(LocalDateTime.of(2023, 5, 15, 15, 0));

        Order savedOrder = new Order();
        savedOrder.setOrderId(1L);
        savedOrder.setNumberOfSeats(2);
        savedOrder.setTimeOfDeparture(LocalDateTime.of(2023, 5, 15, 12, 0));
        savedOrder.setTimeOfArrival(LocalDateTime.of(2023, 5, 15, 15, 0));

        when(orderRepository.save(order)).thenReturn(savedOrder);
        when(objectMapper.convertValue(savedOrder, OrderDTO.class)).thenReturn(orderDTO);

        OrderDTO createdOrderDTO = orderService.createOrder(orderDTO);

        verify(orderRepository, times(1)).save(order);
        verify(objectMapper, times(1)).convertValue(savedOrder, OrderDTO.class);
        assertEquals(savedOrder.getOrderId(), createdOrderDTO.getOrderId());
        assertEquals(savedOrder.getNumberOfSeats(), createdOrderDTO.getNumberOfSeats());
        assertEquals(savedOrder.getTimeOfDeparture(), createdOrderDTO.getTimeOfDeparture());
        assertEquals(savedOrder.getTimeOfArrival(), createdOrderDTO.getTimeOfArrival());
    }
}

