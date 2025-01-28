package com.exampleateffigo.one_to_one_p2.repository;

import com.exampleateffigo.one_to_one_p2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
