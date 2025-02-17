package com.exampleateffigo.coursemanagement.repository;

import com.exampleateffigo.coursemanagement.entity.UserInfo;
import com.exampleateffigo.coursemanagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query(value = "SELECT new map(u.userId as userId, u.userName as userName, u.userEmail as userEmail, " +
            "c.courseId as courseId, c.courseName as courseName) " +
            "FROM Users u JOIN u.enrolledCourses c")
    List<Map<String, Object>> findUserEnrollments();

    Optional<Users> findByUserName(String username);
}
