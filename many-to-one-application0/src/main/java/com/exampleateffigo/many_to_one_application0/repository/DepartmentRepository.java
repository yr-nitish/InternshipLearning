package com.exampleateffigo.many_to_one_application0.repository;

import com.exampleateffigo.many_to_one_application0.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
