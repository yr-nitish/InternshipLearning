package com.exampleateffigo.coursemanagement.controller;

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

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollUserInCourse(@RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        Long courseId = request.get("courseId");

        usersService.enrollUserInCourse(userId, courseId);
        return ResponseEntity.ok("User enrolled in course successfully.");
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable long id) {
        return usersService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        usersService.deleteUser(id);
    }
}
