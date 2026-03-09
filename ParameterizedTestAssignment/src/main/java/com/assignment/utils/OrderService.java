package com.assignment.utils;

public class OrderService {

    public boolean canCancel(OrderStatus status) {

        return status == OrderStatus.NEW;
    }
}
