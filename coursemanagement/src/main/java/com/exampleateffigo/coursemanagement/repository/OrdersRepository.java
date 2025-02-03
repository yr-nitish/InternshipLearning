package com.exampleateffigo.coursemanagement.repository;

import com.exampleateffigo.coursemanagement.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
