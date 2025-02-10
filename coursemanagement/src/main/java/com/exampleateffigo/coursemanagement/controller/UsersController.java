package com.exampleateffigo.coursemanagement.controller;

import com.exampleateffigo.coursemanagement.dto.UserRequestDTO;
import com.exampleateffigo.coursemanagement.dto.UserResponseDTO;
import com.exampleateffigo.coursemanagement.entity.Users;
import com.exampleateffigo.coursemanagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/add-user")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(usersService.createUser(userRequestDTO));
    }

    @PostMapping("/enroll")
    public ResponseEntity<UserResponseDTO> enrollUserInCourse(@RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        Long courseId = request.get("courseId");

        UserResponseDTO updatedUser = usersService.enrollUserInCourse(userId, courseId);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable long id)
    {
        return ResponseEntity.ok(usersService.getUserById(id));
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }
}
