package com.exampleateffigo.coursemanagement.repository;

import com.exampleateffigo.coursemanagement.entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
}
