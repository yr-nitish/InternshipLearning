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
@RequestMapping
public class UsersController {

    @Autowired
    private UsersService usersService;

//    @PostMapping("/users/add-user")
//    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
//        return ResponseEntity.ok(usersService.createUser(userRequestDTO));
//    }

    @PostMapping("/auth/user/api/users/enroll")
    public ResponseEntity<UserResponseDTO> enrollUserInCourse(@RequestBody Map<String, Long> request) {
        Long userId = request.get("userId");
        Long courseId = request.get("courseId");

        UserResponseDTO updatedUser = usersService.enrollUserInCourse(userId, courseId);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/auth/admin/api/users/get-all-users")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @GetMapping("/auth/admin/api/users/get-user/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable long id)
    {
        return ResponseEntity.ok(usersService.getUserById(id));
    }

    @GetMapping("/auth/admin/api/users/username/{userName}")
    public ResponseEntity<UserResponseDTO> getUserByUsername(@PathVariable String userName){
        return ResponseEntity.ok(usersService.getUserByName(userName));
    }

    @PatchMapping("/auth/user/api/users/update-email/{id}")
    public ResponseEntity<UserResponseDTO> updateUserEmail(@PathVariable long id, @RequestBody Map<String, String> request) {
        String newEmail = request.get("userEmail");
        return ResponseEntity.ok(usersService.updateUserEmail(id, newEmail));
    }

    @DeleteMapping("/auth/admin/api/users/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }

    @GetMapping("/auth/admin/api/users/enrollments")
    public ResponseEntity<List<Map<String, Object>>> getAllEnrollments() {
        List<Map<String, Object>> enrolledUsers = usersService.getAllEnrollments();

        if (enrolledUsers.isEmpty()) {
            return ResponseEntity.noContent().build(); // Returns 204 No Content if no enrollments exist
        }
        return ResponseEntity.ok(enrolledUsers);
    }
}
