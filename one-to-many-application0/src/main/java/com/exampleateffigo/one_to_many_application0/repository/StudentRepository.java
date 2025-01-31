package com.exampleateffigo.one_to_many_application0.repository;

import com.exampleateffigo.one_to_many_application0.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
