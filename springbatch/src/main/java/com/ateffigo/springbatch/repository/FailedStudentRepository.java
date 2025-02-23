package com.ateffigo.springbatch.repository;

import com.ateffigo.springbatch.entity.FailedStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FailedStudentRepository extends JpaRepository<FailedStudent, Long> {
}
