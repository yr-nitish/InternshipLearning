package com.exampleateffigo.coursemanagement.service;

import com.exampleateffigo.coursemanagement.entity.Courses;
import com.exampleateffigo.coursemanagement.entity.Users;
import com.exampleateffigo.coursemanagement.repository.CoursesRepository;
import com.exampleateffigo.coursemanagement.repository.ReviewsRepository;
import com.exampleateffigo.coursemanagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService
{

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    public Users enrollUserInCourse(Long userId, Long courseId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Courses course = coursesRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (!user.getEnrolledCourses().contains(course)) {
            user.getEnrolledCourses().add(course);
        }
        return usersRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserById(long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public void deleteUser(long id) {
        usersRepository.deleteById(id);
    }
}
