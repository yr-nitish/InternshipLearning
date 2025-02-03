package com.exampleateffigo.coursemanagement.service;

import com.exampleateffigo.coursemanagement.entity.Orders;
import com.exampleateffigo.coursemanagement.entity.Users;
import com.exampleateffigo.coursemanagement.entity.Courses;
import com.exampleateffigo.coursemanagement.repository.CoursesRepository;
import com.exampleateffigo.coursemanagement.repository.OrdersRepository;
import com.exampleateffigo.coursemanagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    public Orders createOrder(long userId, long courseId) {
        Users user = usersRepository.findById(userId).orElseThrow(()  -> new RuntimeException("User not found"));

        Courses course = coursesRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

        Orders order = new Orders();
        order.setUsers(user);
        order.setCourses(course);
        return ordersRepository.save(order);
    }

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Optional<Orders> getOrderById(long id)
    {
        return ordersRepository.findById(id);
    }
}
