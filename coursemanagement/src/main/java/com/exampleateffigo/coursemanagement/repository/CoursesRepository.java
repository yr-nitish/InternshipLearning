package com.exampleateffigo.coursemanagement.repository;

import com.exampleateffigo.coursemanagement.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
}
