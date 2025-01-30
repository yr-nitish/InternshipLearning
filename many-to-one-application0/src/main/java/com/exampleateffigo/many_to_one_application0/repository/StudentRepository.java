package com.exampleateffigo.many_to_one_application0.repository;

import com.exampleateffigo.many_to_one_application0.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
