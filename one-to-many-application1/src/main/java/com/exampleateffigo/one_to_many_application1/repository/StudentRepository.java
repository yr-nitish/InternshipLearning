package com.exampleateffigo.one_to_many_application1.repository;

import com.exampleateffigo.one_to_many_application1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
