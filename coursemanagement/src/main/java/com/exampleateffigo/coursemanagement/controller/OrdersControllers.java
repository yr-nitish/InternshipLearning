package com.exampleateffigo.coursemanagement.controller;

import com.exampleateffigo.coursemanagement.dto.OrderRequestDTO;
import com.exampleateffigo.coursemanagement.dto.OrderResponseDTO;
import com.exampleateffigo.coursemanagement.entity.Orders;
import com.exampleateffigo.coursemanagement.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersControllers {

    @Autowired
    private OrdersService ordersService;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO request) {
        OrderResponseDTO orderResponse = ordersService.createOrder(request);
        return ResponseEntity.ok(orderResponse);
    }

//    @GetMapping
//    public ResponseEntity<List<Orders>> getAllOrders() {
//        List<Orders> orders = ordersService.getAllOrders();
//        return ResponseEntity.ok(orders);
//    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        List<OrderResponseDTO> orders = ordersService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable long id) {
        return ResponseEntity.ok(ordersService.getOrderById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long id) {
        ordersService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
