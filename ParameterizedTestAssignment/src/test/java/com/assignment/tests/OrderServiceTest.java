package com.assignment.tests;

import com.assignment.utils.OrderService;
import com.assignment.utils.OrderStatus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class OrderServiceTest {

    OrderService service = new OrderService();

    @ParameterizedTest
    @EnumSource(OrderStatus.class)
    void testCanCancel(OrderStatus status) {

        if(status == OrderStatus.NEW) {

            assertTrue(service.canCancel(status));

        } else {

            assertFalse(service.canCancel(status));
        }
    }
}
