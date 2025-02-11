package com.exampleateffigo.coursemanagement.controller;

import com.exampleateffigo.coursemanagement.dto.CourseRequestDTO;
import com.exampleateffigo.coursemanagement.dto.CourseResponseDTO;
import com.exampleateffigo.coursemanagement.dto.UserResponseDTO;
import com.exampleateffigo.coursemanagement.entity.Courses;
import com.exampleateffigo.coursemanagement.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @GetMapping("/get-all-courses")
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses()
    {
        return ResponseEntity.ok(coursesService.getAllCourses());
    }

    @GetMapping("/get-course/{id}")
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable long id)
    {
        CourseResponseDTO courseResponseDTO = coursesService.getCourseById(id);
        return ResponseEntity.ok(courseResponseDTO);
    }

    @PostMapping("/add-course")
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody CourseRequestDTO courseRequestDTO) {
        return ResponseEntity.ok(coursesService.createCourse(courseRequestDTO));
    }

    @PutMapping("/update-course/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable long id, @RequestBody CourseRequestDTO courseRequestDTO)
    {
        return ResponseEntity.ok(coursesService.updateCourse(id, courseRequestDTO));
    }

    @DeleteMapping("/delete-course/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable long id) {
        coursesService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully.");
    }

    @GetMapping("/{courseId}/enrolled-users")
    public ResponseEntity<List<UserResponseDTO>> getEnrolledUsers(@PathVariable long courseId) {
        return ResponseEntity.ok(coursesService.getEnrolledUsers(courseId));
    }
}
