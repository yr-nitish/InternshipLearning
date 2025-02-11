package com.exampleateffigo.coursemanagement.repository;

import com.exampleateffigo.coursemanagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u JOIN u.enrolledCourses c")
    List<Users> findAllEnrollments();
}
