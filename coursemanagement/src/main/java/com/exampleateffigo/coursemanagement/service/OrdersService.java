package com.exampleateffigo.coursemanagement.service;

import com.exampleateffigo.coursemanagement.dto.OrderRequestDTO;
import com.exampleateffigo.coursemanagement.dto.OrderResponseDTO;
import com.exampleateffigo.coursemanagement.entity.Orders;
import com.exampleateffigo.coursemanagement.entity.Users;
import com.exampleateffigo.coursemanagement.entity.Courses;
import com.exampleateffigo.coursemanagement.mappers.OrderMapper;
import com.exampleateffigo.coursemanagement.repository.CoursesRepository;
import com.exampleateffigo.coursemanagement.repository.OrdersRepository;
import com.exampleateffigo.coursemanagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private OrderMapper orderMapper;

    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Users user = usersRepository.findById(orderRequestDTO.getUserId())
                .orElseThrow(()  -> new RuntimeException("User not found"));

        Courses course = coursesRepository.findById(orderRequestDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Orders order = new Orders();
        order.setUsers(user);
        order.setCourses(course);

        Orders savedOrder = ordersRepository.save(order);
        return orderMapper.toDTO(savedOrder);
    }

//    public List<Orders> getAllOrders() {
//        return ordersRepository.findAll();
//    }

    public List<OrderResponseDTO> getAllOrders() {
        return ordersRepository.findAll().stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

//    public Optional<Orders> getOrderById(long id)
//    {
//        return ordersRepository.findById(id);
//    }

    public OrderResponseDTO getOrderById(long id) {
        Orders order = ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toDTO(order);
    }

    public void deleteOrder(long id) {
        Orders order = ordersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        ordersRepository.delete(order);
    }
}
