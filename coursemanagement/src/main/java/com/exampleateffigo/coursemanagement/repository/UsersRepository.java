package com.exampleateffigo.coursemanagement.repository;

import com.exampleateffigo.coursemanagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
