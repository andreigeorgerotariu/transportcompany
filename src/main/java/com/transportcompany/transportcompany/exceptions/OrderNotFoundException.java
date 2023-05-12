package com.transportcompany.transportcompany.exceptions;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String order, String id, long orderId) {
    }
}
