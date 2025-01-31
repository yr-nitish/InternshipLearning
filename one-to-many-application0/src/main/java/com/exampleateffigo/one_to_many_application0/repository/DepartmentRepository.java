package com.exampleateffigo.one_to_many_application0.repository;

import com.exampleateffigo.one_to_many_application0.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
