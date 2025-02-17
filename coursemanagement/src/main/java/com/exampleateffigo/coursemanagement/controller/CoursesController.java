package com.exampleateffigo.coursemanagement.controller;

import com.exampleateffigo.coursemanagement.dto.CourseRequestDTO;
import com.exampleateffigo.coursemanagement.dto.CourseResponseDTO;
import com.exampleateffigo.coursemanagement.dto.UserResponseDTO;
import com.exampleateffigo.coursemanagement.entity.Courses;
import com.exampleateffigo.coursemanagement.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @GetMapping({"/auth/user/api/courses/get-all-courses", "/auth/admin/api/courses/get-all-courses"})
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses()
    {
        return ResponseEntity.ok(coursesService.getAllCourses());
    }

    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    @GetMapping({"/auth/admin/api/courses/get-course/{id}", "/auth/user/api/courses/get-course/{id}"})
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable long id)
    {
        CourseResponseDTO courseResponseDTO = coursesService.getCourseById(id);
        return ResponseEntity.ok(courseResponseDTO);
    }

    @PostMapping("/auth/admin/api/courses/add-course")
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody CourseRequestDTO courseRequestDTO) {
        return ResponseEntity.ok(coursesService.createCourse(courseRequestDTO));
    }

    @PutMapping("/auth/admin/api/courses/update-course/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable long id, @RequestBody CourseRequestDTO courseRequestDTO)
    {
        return ResponseEntity.ok(coursesService.updateCourse(id, courseRequestDTO));
    }

    @DeleteMapping("/auth/admin/api/courses/delete-course/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable long id) {
        coursesService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully.");
    }

    @GetMapping("auth/admin/api/courses/{courseId}/enrolled-users")
    public ResponseEntity<List<UserResponseDTO>> getEnrolledUsers(@PathVariable long courseId) {
        return ResponseEntity.ok(coursesService.getEnrolledUsers(courseId));
    }
}
