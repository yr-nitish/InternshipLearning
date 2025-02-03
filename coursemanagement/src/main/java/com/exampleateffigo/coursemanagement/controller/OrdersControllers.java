package com.exampleateffigo.coursemanagement.controller;

import com.exampleateffigo.coursemanagement.entity.Orders;
import com.exampleateffigo.coursemanagement.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersControllers {

    @Autowired
    private OrdersService ordersService;

    @PostMapping
    public Orders createOrder(@RequestParam long userId, @RequestParam long courseId) {
        return ordersService.createOrder(userId, courseId);
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Orders> getOrderById(@PathVariable long id)
    {
        return ordersService.getOrderById(id);
    }
}
