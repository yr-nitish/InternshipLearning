package com.exampleateffigo.coursemanagement.service;

import com.exampleateffigo.coursemanagement.dto.UserRequestDTO;
import com.exampleateffigo.coursemanagement.dto.UserResponseDTO;
import com.exampleateffigo.coursemanagement.entity.Courses;
import com.exampleateffigo.coursemanagement.entity.Users;
import com.exampleateffigo.coursemanagement.mappers.UserMapper;
import com.exampleateffigo.coursemanagement.repository.CoursesRepository;
import com.exampleateffigo.coursemanagement.repository.ReviewsRepository;
import com.exampleateffigo.coursemanagement.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UsersService
{
    private Logger logger = LoggerFactory.getLogger(UsersService.class);

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        logger.info("Creating user with request data: {}", userRequestDTO);
        Users user = userMapper.toEntity(userRequestDTO);
        user = usersRepository.save(user);
        logger.info("User created successfully with ID: {}", user.getUserId());
        return userMapper.toResponseDTO(user);
    }

    public UserResponseDTO enrollUserInCourse(Long userId, Long courseId) {
        logger.info("Enrolling user with ID: {} in course with ID: {}",userId, courseId);
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> {
                    logger.error("User not found with ID: {}", userId);
                return new RuntimeException("User not found");
                });
        Courses course = coursesRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (!user.getEnrolledCourses().contains(course)) {
            user.getEnrolledCourses().add(course);
            logger.error("User ID: {} successfully enrolled in course ID: {}", userId, courseId);
        }
        else {
            logger.warn("User ID: {} is already enrolled in course ID: {}", userId, courseId);
        }

        Users updatedUser = usersRepository.save(user);
        return userMapper.toResponseDTO(updatedUser);
    }

    public List<UserResponseDTO> getAllUsers()
    {
        logger.info("Fetching all users");
        List<Users> users = usersRepository.findAll();
        logger.info("Total users found: {}", users.size());
        return users.stream()
                .map(userMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(long id) {
        logger.info("Fetching user with ID: {}", id);
        Users user = usersRepository.findById(id).orElseThrow(() ->
        {
            logger.error("User not found with Id: {}", id);
            return new RuntimeException("User not found");
        });
        return userMapper.toResponseDTO(user);
    }

    public void deleteUser(long id) {
        logger.info("Deleting user with ID: {}", id);
        if(!usersRepository.existsById(id))
        {
            logger.warn("Attempted to delete non-existing user with ID: {}",id);
            throw new RuntimeException("User not found");
        }
        usersRepository.deleteById(id);
        logger.info("User with ID: {} deleted successfully", id);
    }
}
